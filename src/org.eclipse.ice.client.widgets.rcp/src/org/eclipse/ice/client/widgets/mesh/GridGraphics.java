package org.eclipse.ice.client.widgets.mesh;

import java.nio.FloatBuffer;
import java.util.concurrent.Callable;

import org.eclipse.ice.client.widgets.jme.SimpleAppState;

import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.scene.debug.Grid;
import com.jme3.scene.shape.Quad;
import com.jme3.util.BufferUtils;

/**
 * This class is designed to manage the graphics representing the Mesh Editor's
 * workspace or environment. Currently, it consists of a bounded grid. To change
 * the size or scale of the grid, update the grid's {@link #dimensions}.
 * 
 * @author Jordan
 * 
 */
public class GridGraphics {

	/**
	 * The {@code SimpleAppState} hosting this {@code GridGraphics}. This is
	 * required so changes to the grid's {@link #dimensions} will be reflected
	 * in the scene graphics.
	 */
	private final SimpleAppState app;

	/**
	 * The root {@code Node} for the grid graphics. This is for convenience.
	 */
	private Node node;

	/**
	 * The backround behind the surface of the grid.
	 */
	private Geometry background;

	/**
	 * The {@link Geometry} representing the surface of the grid.
	 */
	private Geometry surface;

	/**
	 * The border of the grid. This is the black region that signifies the edge
	 * of the grid. If the background and border are the same color, then this
	 * is no longer necessary.
	 */
	private Geometry border;

	/**
	 * The major grid lines.
	 */
	private Geometry majorGrid;

	/**
	 * The minor grid lines.
	 */
	private Geometry minorGrid;

	/**
	 * The dimensions of the grid. Apply any changes directly to this variable
	 * via {@link GridDimensions#set(float, float, float)}. Any valid
	 * changes will result in a call to {@link #refresh()} to update the
	 * graphics.
	 */
	public final GridDimensions dimensions = new GridDimensions() {
		@Override
		public void dimensionsChanged() {
			app.enqueue(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					refresh();
					return true;
				}
			});
		}
	};

	/**
	 * Creates a new {@code GridGraphics} object.
	 * 
	 * @param renderQueue
	 *            The {@code IRenderQueue} used to update the scene. This is
	 *            required so changes to the grid's {@link #dimensions} will be
	 *            reflected in the scene graphics.
	 */
	protected GridGraphics(SimpleAppState app) {
		this.app = app;
	}

	/**
	 * Initializes the grid graphics.
	 */
	protected void init() {

		Quad quad;
		Material material;

		// Create the GridGraphics' own "root" Node.
		node = new Node("grid");

		// Create a background that lies beneath the blue grid.
		quad = new Quad(1f, 1f);
		background = new Geometry("background", quad);
		background.setMaterial(app.createBasicMaterial(ColorRGBA.Gray));
		node.attachChild(background);

		// Create the blue (major) grid.
		majorGrid = new Geometry("majorGrid");
		material = app.createBasicMaterial(ColorRGBA.Blue);
		material.getAdditionalRenderState().setWireframe(true);
		majorGrid.setMaterial(material);
		node.attachChild(majorGrid);

		// Create the minor grid.
		minorGrid = new Geometry("minorGrid");
		material = app.createBasicMaterial(ColorRGBA.Blue);
		material.getAdditionalRenderState().setWireframe(true);
		minorGrid.setMaterial(material);
		node.attachChild(minorGrid);

		// Create the invisible surface of the grid that will register ray hits.
		quad = new Quad(1f, 1f);
		surface = new Geometry("surface", quad);
		material = app.createBasicMaterial(ColorRGBA.BlackNoAlpha);
		material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
		surface.setMaterial(material);
		surface.setQueueBucket(Bucket.Transparent);
		node.attachChild(surface);

		// Create the mesh surrounding the grid. This is basically a large Quad
		// with a hole in the middle for the grid.
		Mesh mesh = new Mesh();
		// Create the float buffers for the vertex locations and the indices of
		// said vertices. The indices will never change, so we set them here.
		int indices[] = { 0, 7, 6, 0, 1, 7, 1, 2, 3, 2, 5, 3, 4, 5, 11, 4, 11,
				10, 8, 10, 9, 6, 8, 9 };
		mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(12 * 3));
		mesh.setBuffer(Type.Index, 3, BufferUtils.createIntBuffer(indices));

		// Create a Geometry from the mesh and set its material.
		border = new Geometry("border", mesh);
		border.setMaterial(app.createBasicMaterial(ColorRGBA.Black));
		// This call is necessary so that the mesh updates its bounds properly.
		border.updateModelBound();

		// Add the cover mesh to the scene.
		node.attachChild(border);

		// Make sure all of the graphics are correctly sized/positioned.
		refresh();

		return;
	}

	/**
	 * Refreshes the grid graphics, assuming they have already been initialized.
	 */
	private void refresh() {

		Mesh mesh;
		Quad quad;
		Grid wireGrid;

		Quaternion wireGridRotation = new Quaternion(new float[] {
				FastMath.HALF_PI, 0f, 0f });

		// Get the jME dimensions for the grid.
		float width = dimensions.getXWorldLength();
		float length = dimensions.getYWorldLength();
		float minX = dimensions.getXWorldMin();
		float minY = dimensions.getYWorldMin();

		// Update the background. We need to resize its mesh with the updated
		// mesh and reset its position since the quad is not already centered at
		// the origin.
		quad = (Quad) background.getMesh();
		quad.updateGeometry(width * 4f, length * 4f);
		background.setLocalTranslation(width * 4f * -0.5f, length * 4f * -0.5f,
				-5f);

		// Update the blue (major) grid's mesh.
		wireGrid = new Grid((int) length + 1, (int) width + 1, 1f);
		wireGrid.setLineWidth(2f);
		majorGrid.setMesh(wireGrid);
		// Rotate the grid and center it on the origin..
		majorGrid.setLocalRotation(wireGridRotation);
		majorGrid.setLocalTranslation(width * -0.5f, length * 0.5f, 0f);

		// Update the minor grid's mesh.
		wireGrid = new Grid((int) length * 4 + 1, (int) width * 4 + 1, 0.25f);
		wireGrid.setLineWidth(1f);
		minorGrid.setMesh(wireGrid);
		// Rotate the grid and center it on the origin.
		minorGrid.setLocalRotation(wireGridRotation);
		minorGrid.setLocalTranslation(width * -0.5f, length * 0.5f, 0f);

		// Update the invisible surface of the grid.
		quad = (Quad) surface.getMesh();
		quad.updateGeometry(width * 4f, length * 4f);
		// Center the surface on the origin.
		surface.setLocalTranslation(width * 4f * -0.5f, length * 4f * -0.5f,
				0f);
		
		// Update the border's mesh.
		mesh = border.getMesh();
		
		// Set the distance from the grid over which the mesh should extend to
		// hide the gray background.
		float d = 50f;
		float w = width, l = length;

		// Get the buffer and rewind it so that we start from the beginning.
		FloatBuffer pb = mesh.getFloatBuffer(Type.Position);
		pb.rewind();
		// Put all of the new vertex locations directly to the float buffer.
		pb.put(minX - d).put(minY - d).put(0f);
		pb.put(minX).put(minY - d).put(0f);
		pb.put(minX + w + d).put(minY - d).put(0f);
		pb.put(minX).put(minY).put(0f);
		pb.put(minX + w).put(minY).put(0f);
		pb.put(minX + w + d).put(minY).put(0f);
		pb.put(minX - d).put(minY + l).put(0f);
		pb.put(minX).put(minY + l).put(0f);
		pb.put(minX + w).put(minY + l).put(0f);
		pb.put(minX - d).put(minY + l + d).put(0f);
		pb.put(minX + w).put(minY + l + d).put(0f);
		pb.put(minX + w + d).put(minY + l + d).put(0f);
		// Forces the mesh to updates its bounds properly.
		// We have to set the buffer again to get the Mesh#updateBound() method
		// to work properly.
		mesh.setBuffer(Type.Position, 3, pb);
		mesh.updateBound();
		border.updateModelBound();
		
		return;
	}

	/**
	 * Gets the root {@code Node} for the grid graphics. This is for
	 * convenience.
	 * 
	 * @return The {@code GridGraphics}' "root" {@code Node}.
	 */
	protected Node getNode() {
		return node;
	}

	/**
	 * Gets the {@link Geometry} representing the surface of the grid.
	 * 
	 * @return The grid surface.
	 */
	protected Geometry getSurface() {
		return surface;
	}

	/**
	 * Gets a valid point on the grid closest to a particular vector.
	 * 
	 * @param point
	 *            The point for which we need the nearest grid point.
	 * @return A new vector for the point on the grid closest to the specified
	 *         vector. <b>Note:</b> This is in jME world units, not model units.
	 */
	protected Vector3f getClosestGridPoint(Vector3f point) {
		Vector3f newPoint = new Vector3f(FastMath.clamp(point.x,
				dimensions.getXWorldMin(), dimensions.getXWorldMax()),
				FastMath.clamp(point.y, dimensions.getYWorldMin(),
						dimensions.getYWorldMax()), 0f);
		return newPoint;
	}
}
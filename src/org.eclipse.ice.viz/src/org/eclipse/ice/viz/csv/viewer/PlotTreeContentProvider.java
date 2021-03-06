/*******************************************************************************
 * Copyright (c) 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.viz.csv.viewer;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.ice.viz.service.csv.PlotProvider;
import org.eclipse.ice.viz.service.csv.PlotTimeIdentifierMapping;
import org.eclipse.ice.viz.service.csv.SeriesProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * 
 * @author Claire Saunders, Matthew Wang
 * 
 */
public class PlotTreeContentProvider implements ITreeContentProvider {

	/**
	 * HashMap of the PlotProvider's title to the PlotProvider
	 */
	HashMap<String, PlotProvider> plotProviderMap = new HashMap<String, PlotProvider>();

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ArrayList<?>) {
			ArrayList<?> plotProviderList = (ArrayList<?>) inputElement;
			// check size of plotProviderList
			if (!(plotProviderList.isEmpty())
					&& plotProviderList.get(0) instanceof PlotProvider) {
				return plotProviderList.toArray();

			}
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof PlotProvider) {
			// Cast into a PlotProvider
			PlotProvider plot = (PlotProvider) parentElement;
			// Put the plot into the hashmap
			plotProviderMap.put(plot.getPlotTitle(), plot);

			ArrayList<Double> times = plot.getTimes();
			// Make a new array of TimeIdentifierMappings
			PlotTimeIdentifierMapping[] timesIdentifierArray = new PlotTimeIdentifierMapping[times
					.size()];
			// Add to the array a mapping of each title to each time
			for (int i = 0; i < times.size(); i++) {
				timesIdentifierArray[i] = new PlotTimeIdentifierMapping(
						plot.getPlotTitle(), times.get(i));
			}
			return timesIdentifierArray;
		} else if (parentElement instanceof PlotTimeIdentifierMapping) {
			// Cast to a PlotTimeIdentifierMapping
			PlotTimeIdentifierMapping plotTime = (PlotTimeIdentifierMapping) parentElement;
			// Get the plot using the map and plot title
			PlotProvider newPlot = plotProviderMap.get(plotTime.getPlotTitle());
			// Return the SeriesProvider list
			return newPlot.getSeriesAtTime(plotTime.getTime()).toArray();
		} else if (parentElement instanceof SeriesProvider) {
			SeriesProvider series = (SeriesProvider) parentElement;
			String[] features = {
					series.getXDataFeature() + " (Independent Variable)",
					series.getYDataFeature() };
			return features;
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

}

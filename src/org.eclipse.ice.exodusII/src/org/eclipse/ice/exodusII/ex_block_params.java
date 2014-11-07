/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.eclipse.ice.exodusII;

public class ex_block_params {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ex_block_params(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ex_block_params obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        exodusIIJNI.delete_ex_block_params(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEdge_blk_id(SWIGTYPE_p_void value) {
    exodusIIJNI.ex_block_params_edge_blk_id_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getEdge_blk_id() {
    long cPtr = exodusIIJNI.ex_block_params_edge_blk_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setEdge_type(String[] value) {
    exodusIIJNI.ex_block_params_edge_type_set(swigCPtr, this, value);
  }

  public String[] getEdge_type() {
	return exodusIIJNI.ex_block_params_edge_type_get(swigCPtr, this);
}

  public void setNum_edge_this_blk(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_edge_this_blk_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_edge_this_blk() {
    long cPtr = exodusIIJNI.ex_block_params_num_edge_this_blk_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_nodes_per_edge(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_nodes_per_edge_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_nodes_per_edge() {
    long cPtr = exodusIIJNI.ex_block_params_num_nodes_per_edge_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_attr_edge(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_attr_edge_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_attr_edge() {
    long cPtr = exodusIIJNI.ex_block_params_num_attr_edge_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setFace_blk_id(SWIGTYPE_p_void value) {
    exodusIIJNI.ex_block_params_face_blk_id_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getFace_blk_id() {
    long cPtr = exodusIIJNI.ex_block_params_face_blk_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setFace_type(String[] value) {
    exodusIIJNI.ex_block_params_face_type_set(swigCPtr, this, value);
  }

  public String[] getFace_type() {
	return exodusIIJNI.ex_block_params_face_type_get(swigCPtr, this);
}

  public void setNum_face_this_blk(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_face_this_blk_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_face_this_blk() {
    long cPtr = exodusIIJNI.ex_block_params_num_face_this_blk_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_nodes_per_face(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_nodes_per_face_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_nodes_per_face() {
    long cPtr = exodusIIJNI.ex_block_params_num_nodes_per_face_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_attr_face(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_attr_face_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_attr_face() {
    long cPtr = exodusIIJNI.ex_block_params_num_attr_face_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setElem_blk_id(SWIGTYPE_p_void value) {
    exodusIIJNI.ex_block_params_elem_blk_id_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getElem_blk_id() {
    long cPtr = exodusIIJNI.ex_block_params_elem_blk_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setElem_type(String[] value) {
    exodusIIJNI.ex_block_params_elem_type_set(swigCPtr, this, value);
  }

  public String[] getElem_type() {
	return exodusIIJNI.ex_block_params_elem_type_get(swigCPtr, this);
}

  public void setNum_elem_this_blk(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_elem_this_blk_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_elem_this_blk() {
    long cPtr = exodusIIJNI.ex_block_params_num_elem_this_blk_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_nodes_per_elem(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_nodes_per_elem_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_nodes_per_elem() {
    long cPtr = exodusIIJNI.ex_block_params_num_nodes_per_elem_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_edges_per_elem(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_edges_per_elem_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_edges_per_elem() {
    long cPtr = exodusIIJNI.ex_block_params_num_edges_per_elem_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_faces_per_elem(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_faces_per_elem_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_faces_per_elem() {
    long cPtr = exodusIIJNI.ex_block_params_num_faces_per_elem_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setNum_attr_elem(SWIGTYPE_p_int value) {
    exodusIIJNI.ex_block_params_num_attr_elem_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getNum_attr_elem() {
    long cPtr = exodusIIJNI.ex_block_params_num_attr_elem_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setDefine_maps(int value) {
    exodusIIJNI.ex_block_params_define_maps_set(swigCPtr, this, value);
  }

  public int getDefine_maps() {
    return exodusIIJNI.ex_block_params_define_maps_get(swigCPtr, this);
  }

  public ex_block_params() {
    this(exodusIIJNI.new_ex_block_params(), true);
  }

}
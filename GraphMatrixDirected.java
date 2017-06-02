public GraphMatrixDirected(int size)
// pre: size > 0
// post: constructs an empty graph that may be expanded to
// at most size vertices. Graph is directed if dir true
// and undirected otherwise
{
	super(size,true);
}

public void addEdge(V vLabel1, V vLabel2, E label)
// pre: vLabel1 and vLabel2 are labels of existing vertices
// post: an edge is inserted between vLabel1 and vLabel2;
// if edge is new, it is labeled with label (can be null)
{
	GraphMatrixVertex<V> vtx1,vtx2;
	// get vertices
	vtx1 = dict.get(vLabel1);
	vtx2 = dict.get(vLabel2);
	// update matrix with new edge
	Edge<V,E> e = new Edge<V,E>(vtx1.label(),vtx2.label(),label,true);
	data[vtx1.index()][vtx2.index()] = e;
}

abstract public class GraphMatrix<V,E>
	implements Graph<V,E>
{
	protected int size; // allocation size for graph
	protected Object data[][]; // matrix - array of arrays
	protected Map<V,GraphMatrixVertex<V>> dict; // labels -> vertices
	protected List<Integer> freeList; // available indices in matrix
	protected boolean directed; // graph is directed

	protected GraphMatrix(int size, boolean dir)
	{
		this.size = size; // set maximum size
		directed = dir; // fix direction of edges
		// the following constructs a size x size matrix
		data = new Object[size][size];
		// label to index translation table
		dict = new Hashtable<V,GraphMatrixVertex<V>>(size);
		// put all indices in the free list
		freeList = new SinglyLinkedList<Integer>();
		for (int row = size-1; row >= 0; row--)
		freeList.add(new Integer(row));
	}

	public void add(V label)
	// pre: label is a non-null label for vertex
	// post: a vertex with label is added to graph;
	// if vertex with label is already in graph, no action
	{
		// if there already, do nothing
		if (dict.containsKey(label)) return;
		// verificar que aun existan indices disponibles para el vertice
		// allocate a free row and column
		int row = freeList.removeFirst().intValue();
		// add vertex to dictionary
		dict.put(label, new GraphMatrixVertex<V>(label, row));
	}

	public V remove(V label)
	// pre: label is non-null vertex label
	// post: vertex with "equals" label is removed, if found
	{
		// find and extract vertex
		GraphMatrixVertex<V> vert;
		vert = dict.remove(label);
		if (vert == null) return null;
		// remove vertex from matrix
		int index = vert.index();
		// clear row and column entries
		for (int row=0; row<size; row++) {
			data[row][index] = null;
			data[index][row] = null;
		}
		// add node index to free list
		freeList.add(new Integer(index));
		return vert.label();
	}

	abstract public void addEdge(V v1, V v2, E label);
	// pre: vtx1 and vtx2 are labels of existing vertices
	// post: an edge (possibly directed) is inserted between
	// vtx1 and vtx2.

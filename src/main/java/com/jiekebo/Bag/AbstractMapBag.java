package com.jiekebo.Bag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AbstractMapBag implements Bag {

	private Map map;
	private int size = 0;
	
	public AbstractMapBag(Map map) {
		super();
		this.map = map;
	}
	
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(Object o) {
		return add(o, 1);
	}

	@Override
	public boolean add(Object o, int copies) {
		if(copies > 0) {
			Integer count = (Integer) map.get(o);
			size += copies;
			if(count == null) {
				map.put(o, new Integer(copies));
				return true;
			} else {
				count += copies;
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o, int copies) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set uniqueSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean containsAll(Collection collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

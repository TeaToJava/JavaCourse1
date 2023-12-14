package com.javacourse.task1;

import java.util.Collection;
import java.util.Comparator;

public interface List<E> {
	public int size();
	public boolean add(E value);
	public void add(int index, E element);
	public E get(int index);
	public boolean remove(Object o);
	public E remove(int index);
	public boolean addAll(Collection<? extends E> c);
	public boolean addAll(int index, Collection<? extends E> c);
	public void bubbleSortWithFlag(Comparator<E> c);
}
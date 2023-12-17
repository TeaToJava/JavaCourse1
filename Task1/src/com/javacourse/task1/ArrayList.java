package com.javacourse.task1;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;

public class ArrayList<E> implements List<E> {
	private E[] array;
	private int length = 0;
	private E[] temp;

	public ArrayList(E[] array) {
		this.array = array;
		this.length = array.length;
	}

	@Override
	public int size() {
		return array.length;
	}

	@SuppressWarnings("unchecked")
	public boolean add(E value) {
		temp = array;
		array = (E[]) Array.newInstance(value.getClass(), ++length);
		for (int i = 0; i < length - 1; i++) {
			array[i] = temp[i];
		}
		array[length - 1] = value;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, E element) {
		temp = array;
		array = (E[]) Array.newInstance(element.getClass(), ++length);
		for (int i = 0; i < index; i++) {
			array[i] = temp[i];
		}
		array[index] = element;
		for (int i = index + 1, j = index; i < length; i++, j++) {
			array[i] = temp[j];
		}
	}

	@Override
	public E get(int index) {
		return array[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		boolean isContained = false;
		E element = (E) o;
		for (int i = 0; i < length; i++) {
			if (array[i].equals(element)) {
				isContained = true;
				if (isContained) {
					removeFromArray(element, i);
				}
				break;
			}
		}
		return isContained;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		} else {
			E element = array[index];
			removeFromArray(element, index);
			return element;
		}
	}

	@SuppressWarnings("unchecked")
	private void removeFromArray(E element, int index) {
		temp = array;
		array = (E[]) Array.newInstance(element.getClass(), --length);
		for (int i = 0; i < index; i++) {
			array[i] = temp[i];
		}
		for (int i = index, j = index+1; i < length; i++, j++) {
			array[i] = temp[j];
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c.isEmpty()) {
			return false;
		}
		createNewArrayForAddAll(c);
		int tempLength = temp.length;
		for (int i = 0; i < tempLength; i++) {
			array[i] = temp[i];
		}
		E[] collection = (E[]) c.toArray();
		for (int i = tempLength, j = 0; i < length; i++, j++) {
			array[i] = collection[j];
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		}
		if (c.isEmpty()) {
			return false;
		}
		createNewArrayForAddAll(c);

		for (int i = 0; i < index; i++) {
			array[i] = temp[i];
		}
		E[] collection = (E[]) c.toArray();
		int collectionLength = collection.length;
		for (int i = index, j = 0; j < collectionLength; i++, j++) {
			array[i] = collection[j];
		}
		for (int i = index + collectionLength, j = index; i < length; i++, j++) {
			array[i] = temp[j];
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private void createNewArrayForAddAll(Collection<? extends E> c) {
		temp = array;
		length = length + c.size();
		array = (E[]) Array.newInstance(temp[0].getClass(), length);
	}

	@Override
	public void bubbleSortWithFlag(Comparator<E> c) {
		boolean isSorted;
		int size = array.length;
		for (int i = 0; i < size - 1; i++) {
			isSorted = true;
			for (int j = 0; j < size - 1 - i; j++) {
				if (c.compare(array[j], array[j + 1]) > 0) {
					E temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSorted = false;
				}
			}
			if (isSorted) {
				break;
			}
		}

	}

}
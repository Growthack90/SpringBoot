package classiMie;

public class DynamicArray {
	private Object[] array;
	
	public DynamicArray() {
		this.array = new Object[0];
	}
	
	public void add(Object element) {
		Object[] temp = this.array;
		this.array = new Object[array.length + 1];
		for (int i = 0; i < temp.length; i++) {
			array[i] = temp[i];
		}
		this.array[this.array.length - 1] = element;
	}
	
	public void remove(int index) {
		if (index < 0 || index >= array.length) {
			return;
		}
		Object[] temp = this.array;
		this.array = new Object[array.length - 1];
		for (int i = 0; i < index; i++) {
			array[i] = temp[i];
		}
		for (int i = index; i < array.length; i++) {
			array[i] = temp[i + 1];
		}
	}
	
	public void update(int index, Object element) {
		if (index < 0 || index >= array.length) {
			return;
		}
		this.array[index] = element;
	}
	
	public void set(int index, Object element) {
        this.update(index, element);
    }
	
	public Object get(int index) {
		if (index < 0 || index >= array.length) {
			return null;
		}
		return this.array[index];
	}
	
	public void printAll() {
		for (int i = 0; i < array.length; i++) {
			IO.println(array[i]);
		}
	}
	
	public int size() {
		return this.array.length;
	}
	
	
}

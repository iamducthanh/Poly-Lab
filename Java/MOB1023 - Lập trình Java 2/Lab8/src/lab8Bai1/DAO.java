package lab8Bai1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class DAO<Entity> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<Entity> list = new ArrayList();

	public void addEntity(Entity entity) {
		list.add(entity);
	}

	public void removeEntity(Entity entity) {
		list.remove(entity);
	}

	abstract public void update(Entity entity);

	abstract public Entity find(Serializable id);

	public List<Entity> getList() {
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void store(String path) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			list = (List<Entity>) ois.readObject();
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void load(String path) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(path);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

package lab8Bai1;

import java.io.Serializable;

public class ProductDAO extends DAO <Product> {
	@Override
	public void update(Product entity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equalsIgnoreCase(entity.name)) {
				list.set(i, entity);
			}
		}
	}

	@Override
	public Product find(Serializable id) {
		for (Product p : list) {
			if (p.name.equals(id)) {
				return p;
			}
		}
		return null;
	}
}

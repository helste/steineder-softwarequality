package org.se.lab;

public abstract class Entity
{
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Entity entity = (Entity) obj;

		return id == entity.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}

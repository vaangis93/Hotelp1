package app.genericif;

import java.util.List;

public interface GenericInterfaceDAO<T, D>{

List<T> getAll();

T GetById(int id);

void create(T entity);

void delete(T entity, D id);



}

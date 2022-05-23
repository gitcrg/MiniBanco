package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {
	T save(T objeto);
	T read(Long id);
	T update(T t);
	void delete(T t);
	Collection<T> readAll();
}

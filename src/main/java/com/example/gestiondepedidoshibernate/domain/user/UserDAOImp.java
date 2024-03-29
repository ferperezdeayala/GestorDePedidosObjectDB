package com.example.gestiondepedidoshibernate.domain.user;

import com.example.gestiondepedidoshibernate.domain.DAO;
import com.example.gestiondepedidoshibernate.domain.ObjectDBUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta de DAO para la entidad User.
 */
public class UserDAOImp implements DAO<User> {

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios almacenados.
     */
    @Override
    public List<User> getAll() {
        List<User> salida;

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            TypedQuery<User> query = em.createQuery("select u from User u", User.class);
            salida =  query.getResultList();
        } finally {
            em.close();
        }
        return salida;
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id El ID del usuario a obtener.
     * @return El usuario correspondiente al ID especificado.
     */
    @Override
    public User get(Long id) {
        User salida = null;
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            salida = em.find(User.class, id);
        } finally {
            em.close();
        }
        return salida;
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param data El usuario a guardar.
     * @return El usuario guardado.
     */
    @Override
    public User save(User data) {
        return null; // No hace nada
    }

    /**
     * Guarda una lista de usuarios en la base de datos.
     * Utiliza JPA (Java Persistence API) para realizar la operación de persistencia.
     *
     * @param usuarios La lista de usuarios que se va a guardar en la base de datos.
     * @throws javax.persistence.PersistenceException Si ocurre un error durante la operación de persistencia.
     */
    public void saveAll(List<User> usuarios) {
        // Se obtiene una instancia del EntityManager.
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            // Se inicia una transacción antes de realizar la operación de persistencia.
            em.getTransaction().begin();

            // Se itera sobre la lista de usuarios y se guarda cada uno en la base de datos.
            for (User u : usuarios) {
                em.persist(u);
            }

            // Se realiza un commit para confirmar la transacción.
            em.getTransaction().commit();
        } finally {
            // Se asegura de cerrar el EntityManager, independientemente de si la transacción fue exitosa o no.
            em.close();
        }
    }



    /**
     * Actualiza un usuario existente.
     *
     * @param data El usuario a actualizar.
     */
    @Override
    public User update(User data) {
        return null;
    }

    /**
     * Elimina un usuario existente.
     *
     * @param data El usuario a eliminar.
     */
    @Override
    public Boolean delete(User data) {
        return null;
    }

    /**
     * Valida un usuario por su nombre de usuario y contraseña.
     *
     * @param nombre Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     * @return El usuario validado o null si no se encuentra.
     */
    public User validateUser(String nombre, String contraseña) {
        User result = null;
        List<User> lista = new ArrayList<>();
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.nombre = :u AND u.contrasenya = :p", User.class);
            query.setParameter("u", nombre);
            query.setParameter("p", contraseña);
            lista = query.getResultList();

            // Check if the list is not empty before trying to access its elements
            if (!lista.isEmpty()) {
                result = lista.get(0);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

        return result;
    }

}
package com.inventory.dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.model.Product;
import com.util.HibernateUtil;

public class ProductDao {

   
    public void addProduct(Product p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);

        tx.commit();
        session.close();
    }

    public List<Product> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery("from Product", Product.class).list();

        session.close();
        return list;
    }

   
    public void deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);
        if (p != null) {
            session.delete(p);
        }

        tx.commit();
        session.close();
    }

   
    public void updateProduct(int id, int qty, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);
        if (p != null) {
            p.setProdQty(qty);
            p.setPrice(price);
            session.update(p);
        }

        tx.commit();
        session.close();
    }
}
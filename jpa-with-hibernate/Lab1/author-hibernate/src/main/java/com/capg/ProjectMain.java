package com.capg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProjectMain {
		EntityManagerFactory emf;
		
		public static void main(String args[]) {
			 ProjectMain project = new ProjectMain();
		        project.execute();
		}
		  void execute() {
		        //entity manager factory created
		        emf = Persistence.createEntityManagerFactory("author-mgt");
		        Author author=createAuthor();
		        Author author1=new Author(1,"krishna","kumar","ahirwar","9039966967");
		        author1=updateAuthor(author1);
		        print(author1);
		        
		  }

		       public  void print(Author author1){
		            System.out.println("author id :"+author1.getAuthorId()+" "+"author first name:"+author1.getAuthorFirstName()+" "+
		        "author middle name :"+author1.getAuthorMiddleName()+" "+"author last name:"+author1.getAuthorLastName()+" "+
		            		"author phone no"+author1.getAuthorPhoneNum());

		        }
		public Author createAuthor() {
			 EntityManager em = emf.createEntityManager();
	            EntityTransaction transaction = em.getTransaction();
	            transaction.begin();
	            Author author=new Author(1,"krishna","kumar","gautam","9039966968");
	            em.persist(author);
	            transaction.commit();
	            System.out.println("author has been added");
	            em.close();
	            return author;
		}
		 public void removeAuthorById(int id){
		        EntityManager em = emf.createEntityManager();
		        EntityTransaction transaction = em.getTransaction();
		        transaction.begin();
		        Author author=em.find(Author.class,id);
		        em.remove(author);
		        transaction.commit();
		        em.close();
		        System.out.println("author has been deleetd");
		    }
		public Author updateAuthor(Author author){
		        EntityManager em = emf.createEntityManager();
		        EntityTransaction transaction = em.getTransaction();
		        transaction.begin();
		        Author autho=em.merge(author);
		        transaction.commit();
		        em.close();
		        return autho;
		    }
		public Author findAuthorById(int id) {
		        EntityManager em = emf.createEntityManager();
		        EntityTransaction transaction = em.getTransaction();
		        transaction.begin();
		        Author autho = em.find(Author.class, id);
		        transaction.commit();
		        em.close();
		        return autho;
		    }
		  
}

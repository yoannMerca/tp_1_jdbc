package com.tp_1_jdbc;

import java.util.Scanner;

import dao.DAOCategorie;


public class App{
    public static void main( String[] args ){
    	String cat;
    	int id;
    	Scanner scan = new Scanner(System.in);
    	boolean end= false;
    	while (!end) {
    		System.out.println("Que voulez vous faire ? \r\n"
        			+ "--1--lister toutes categorie \r\n"
        			+ "--2--Updater une categorie \r\n"
        			+ "--3--delete une cathegorie \r\n"
        			+ "--4--creer une categorie \r\n"
        			+ "--5--Fin du programme");
        	int choix = Integer.parseInt(scan.nextLine());
        	switch (choix) {
    		case 1:
    			DAOCategorie.getAllCategorie();
    			break;
    		case 2:
    			System.out.println("saisir l'id de la categorie a modifier");
    			id  = Integer.parseInt(scan.nextLine());
    			System.out.println("saisir le nouveau nom de la categorie");
    			cat = scan.nextLine();
    			try {
    				DAOCategorie.updateCategorie(id,cat);
    		       } catch (Exception e) {
    		    	   System.out.println(e.getMessage());
    		       }
    			break;
    		case 3:
    			System.out.println("saisir l'id de la categorie à supprimer");
    			id  = Integer.parseInt(scan.nextLine());
    			try {
    				DAOCategorie.deleteCategorie(id);
				} catch (Exception e) {
					 System.out.println(e.getMessage());
				}
    			break;
    		case 4:
    			
    			System.out.println("saisir la nouvelle categorie");
    			cat = scan.nextLine();
    			try {
    				DAOCategorie.insertCategorie(cat);
    		       } catch (Exception e) {
    		    	   System.out.println(e.getMessage());
    		       }
    			break;
    		case 5:
    			default:
				
    			System.out.println("a+");
    			end = true;
    			break;
    		}
			
		}
    	
       
       
       
       
       scan.close();
    } 
}

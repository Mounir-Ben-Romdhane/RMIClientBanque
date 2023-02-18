package service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Scanner;

public class client {

public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		
		try {
			
				IBanqueRemote stub=(IBanqueRemote)Naming.lookup("rmi://localhost:5590/BK");
				
				System.out.println("\tBienvenu dans notre Banque !");
				
			for(int i=0;i<1000;i++) {
				System.out.println("\tChoisier votre operation :");
				System.out.println("1-Convertir un montant !\t2-ajouter un compte !\n3-inforomation d'un compte !\t4-Conselter compte !\n5-liste de comptes !\t6-Crediter un compte !\n\t7-Debiter un compte !");
				Scanner scan = new Scanner(System.in);
				char choix = scan.nextLine().charAt(0);
				
				switch(choix) {
				case '1' : {
				 System.out.println("Donner le montant en dinar :");
				 Double x= scan.nextDouble();
				 System.out.println("Ce montant en euro :");
				 System.out.println(stub.Conv(x));
				 System.out.println("********************************************");
				 break;}
				 
				case '2' : {
				 System.out.println("Donner votre code :");
				 int id= scan.nextInt();
				 System.out.println("Donner votre montant :");
				 Double soulde= scan.nextDouble();
				 
				 compte c = new compte(id,soulde);
				 stub.ajoutCompte(c);
				 System.out.println("Compte ajouter avec sécces!");
				 System.out.println("********************************************");
				 break;
				}
				case '3' : {
				 System.out.println("Donner le code de compte :");
				 int id1= scan.nextInt();
				 System.out.println( stub.getInfo(id1));
				 System.out.println("********************************************");
				break;
				}
				case '4' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					 System.out.println(stub.conselterCompte(id2).toString());
					 System.out.println("********************************************");
					 break;
					
				}
				case '5' : {
					System.out.println("La liste de comptes :");
					compte c1[]=stub.getLists();
					
					for(int j=0;j<c1.length;j++) {
						if(c1[j]!=null) {
						System.out.println(c1[j].toString());
						}
					}
					 System.out.println("********************************************");
					break;
				}
				case '6' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					System.out.println("Donner la montant créditer :");
					 Double soulde= scan.nextDouble();
					 stub.crediter(id2,soulde);
					 System.out.println("********************************************");
					 break;
				
				}
				
				case '7' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					System.out.println("Donner la montant créditer :");
					 Double soulde= scan.nextDouble();
					 stub.debiter(id2,soulde);
					 System.out.println("********************************************");
					 break;
				
				}
				}	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}


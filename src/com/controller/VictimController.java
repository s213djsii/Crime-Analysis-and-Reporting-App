package com.controller;



import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

import com.exceptions.InvalidIncidentDataException;
import com.exceptions.InvalidVictimDataException;
import com.model.Victim;
import com.service.VictimService;

public class VictimController {
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		VictimService victimService=new VictimService();
		while(true) {
			System.out.println("Press 1. To Add a Victim");
			System.out.println("Press 2. To Delete a Victim");
			System.out.println("Press 3. To Display Victim by Incident Id");
			System.out.println("Press 4. To Search Victim By Name");
			System.out.println("Press 0. To Exit");
			int in=sc.nextInt();
			if(in==0)
			{
				System.out.println("Exiting.... Thank You");
				break;
			}
			switch(in)
			{
			case 1:
				System.out.println("Inserting values");
				System.out.println("Enter firstName:");
				String firstName=sc.next();
				System.out.println("Enter lastName:");
				String lastName=sc.next();
				System.out.println("Enter dob:");
				String dobString = sc.next();
				LocalDate dob = LocalDate.parse(dobString);
							
				System.out.println("Enter gender:");
				String gender=sc.next();
				System.out.println("Enter phone no:");
				String contactInfo=sc.next();
				System.out.println("Enter incident id:");
				int incidentId=sc.nextInt();
				Victim victim=new Victim(firstName,lastName,dob,gender,contactInfo,incidentId);
				try {
					victimService.addRecord(victim);
					System.out.println("inserted successfully");
				} catch (ClassNotFoundException | SQLException | InvalidIncidentDataException e) {
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Deleting Victim Record");
				System.out.println("Enter victim id:");
				int id2=sc.nextInt();
				try {
					victimService.deleteVictim(id2);
				} catch (ClassNotFoundException | SQLException | InvalidVictimDataException e1) {
					System.out.println(e1.getMessage());
					
				}

				break;
			case 3:
				System.out.println("Displaying Victim details by using Incident Id");
				System.out.println("Enter incident id:");
				int id1=sc.nextInt();
				
				try {
					List<Victim> v = victimService.getVictim(id1);
					if(v.isEmpty())
					{
						System.out.println("Invalid Id");
					}
					else {
						for(Victim vic:v)
						{
							System.out.println(vic);
						}
					}
					
					
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
				}
				
				break;
			case 4:
				System.out.println("Displaying Victim details by using name");
				System.out.println("Enter name:");
				String name=sc.next();
				try {
					List<Victim> v = victimService.getVictimByName(name);
					if(v.isEmpty())
					{
						System.out.println("Invalid name");
					}
					else {
						for(Victim vic:v)
						{
							System.out.println(vic);
						}
					}
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
				}
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}
	

}

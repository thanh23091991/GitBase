package CustomerManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller {
	Scanner sc = new Scanner(System.in);
	Model model1 = new Model();
	List<Controller> listCustomer = new ArrayList<Controller>();
	public void TableOfConten() {
		//ducnv5   
		System.out.println("--- Table of Content ---");
		System.out.println("1. Nháº­p thÃ´ng tin khÃ¡ch hÃ ng?");
		System.out.println("2. Hiá»ƒn thá»‹ danh sÃ¡ch khÃ¡ch hÃ ng?");
		System.out.println("3. Cáº­p nháº­t thÃ´ng tin khÃ¡ch hÃ ng?");
		System.out.println("4. XÃ³a thÃ´ng tin khÃ¡ch hÃ ng?");
		System.out.println("5. Sáº¯p xáº¿p thÃ´ng tin khÃ¡ch hÃ ng?"); //buddy sort, insertion sort, selection sort
		System.out.println("6. ThoÃ¡t chÆ°Æ¡ng trÃ¬nh?");
		System.out.println("==> Input?");
	}
	public void Edit() {
		
		System.out.println("MÃ£ khÃ¡ch hÃ ng?");
		model1.RollNo = Integer.parseInt(sc.nextLine());
		System.out.println("TÃªn khÃ¡ch hÃ ng?");
		model1.FullName =  sc.nextLine();
		System.out.println("Nháº­p Email?");
		model1.Email = sc.nextLine();
		System.out.println("- Má»�i nháº­p Ä‘iá»‡n thoáº¡i?");
		model1.Mobile = sc.nextLine();
		System.out.println("- Ä�á»‹a chá»‰ cá»§a khÃ¡ch hÃ ng?");
		model1.Address = sc.nextLine();
	}
	public void EnterInfoCustomer() {
		int n;
		while(true) {
			try {
				System.out.println("Báº¡n muá»‘n nháº­p bao nhiÃªu khÃ¡ch hÃ ng?");
				 n = Integer.parseInt(sc.nextLine());
				 if(n<=0)
					 throw new NumberFormatException();
				break;
			}catch(NumberFormatException e) {
				System.out.println("Báº¡n cáº§n nháº­p vÃ o má»™t sá»‘ nguyÃªn dÆ°Æ¡ng");
			}
		}
		for(int i = 0;i<n;i++) {
			//Khai bÃ¡o má»™t Ä‘á»‘i tÆ°á»£ng chÆ°a thÃ´ng tin khÃ¡ch hÃ ng
			Controller controller1 = new Controller();
			System.out.println("KhÃ¡ch hÃ ng thá»© "+ (i+1));
			controller1.Edit();
			listCustomer.add(controller1);
		}
	}
	public void ShowInfoCustomer() {
		if(listCustomer.size()>0) {
			for(Controller oCust: listCustomer) {
				System.out.println("MÃ£ khÃ¡ch hÃ ng lÃ  " + oCust.model1.getRollNo());
				System.out.println("TÃªn khÃ¡ch hÃ ng lÃ  " + oCust.model1.getFullName());
				System.out.println("Há»™p thÆ° Ä‘iá»‡n tá»­ lÃ  "+ oCust.model1.getEmail());
				System.out.println("Sá»‘ Ä‘iá»‡n thoáº¡i lÃ  " + oCust.model1.getMobile());
				System.out.println("Ä�á»‹a chá»‰ khÃ¡ch hÃ ng lÃ  "+ oCust.model1.getAddress());
			}
		}
	}
	public void UpdateCustomer() {
		if(listCustomer.size()>0) {
			int rollno;
			while(true) {
				try {
					System.out.println("Nháº­p mÃ£ khÃ¡ch hÃ ng báº¡n muá»‘n sá»­a!");
					rollno = Integer.parseInt(sc.nextLine());
					 if(rollno<=0)
						 throw new NumberFormatException();
					break;
				}catch(NumberFormatException e) {
					System.out.println("Báº¡n cáº§n nháº­p vÃ o má»™t sá»‘ nguyÃªn dÆ°Æ¡ng");
				}
			}
			for(Controller oCust: listCustomer) {
				if(rollno == oCust.model1.getRollNo()) {
					listCustomer.get(oCust.model1.getRollNo()).Edit();
				}
			}
		}
	}
	public void DeleteCustomer() {
		if(listCustomer.size()>0) {
			int rollno;
			while(true) {
				try {
					System.out.println("Nháº­p mÃ£ khÃ¡ch hÃ ng báº¡n muá»‘n sá»­a!");
					rollno = Integer.parseInt(sc.nextLine());
					 if(rollno<=0)
						 throw new NumberFormatException();
					break;
				}catch(NumberFormatException e) {
					System.out.println("Báº¡n cáº§n nháº­p vÃ o má»™t sá»‘ nguyÃªn dÆ°Æ¡ng");
				}
			}
			for(Controller oCust: listCustomer) {
				if(rollno == oCust.model1.getRollNo()) {
					listCustomer.remove(oCust.model1.getRollNo());
				}
			}
		}
	}
	public void SortCustomer() {
		Collections.sort(listCustomer ,(Controller Ct1, Controller Ct2)->{
			if(Ct1.model1.getRollNo()<Ct2.model1.getRollNo())
				return 1;
			else {
				if(Ct1.model1.getRollNo()==Ct2.model1.getRollNo())
					return  0;
				else
					return -1;
			}
		});
	}
	
	static boolean IsEmpty(String sValue) {
		return sValue.isEmpty() ? true : false;
	}

	static boolean IsNumeric(String sValue) {
		return sValue.matches("^[-+]?\\d+(\\.\\d+)?$");
	}

	static boolean IsSatisfy(byte bValue) {
		return (bValue < 1 || bValue > 6) ? false : true;
	}
	static byte CheckInfo(String sValue) {
		if(!IsEmpty(sValue))
			if(IsNumeric(sValue)) {
				byte bValue = Byte.parseByte(sValue);
				if(IsSatisfy(bValue))
					return 0;
				else 
					return 3;				
			}else
				return 2;			
		else 
			return 1;		
	}		
}

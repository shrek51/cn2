import java.util.Scanner;

public class LeakyBucket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Bucket Size: ");
		int b_size;
		b_size = sc.nextInt();
		System.out.println("Enter the Output Rate:");
		int op_rate;
		op_rate = sc.nextInt();
		System.out.println("Enter the Number of Packets:");
		int num;
		num = sc.nextInt();
		int pkts[] = new int [num];
		System.out.println("Enter the packets:");
		for(int i = 0; i<num; i++) {
			pkts[i] = sc.nextInt();
		}
		System.out.println("Rec_Pkt_Size \tBuc_Content \t Ac/Rej \tRem_Buc_content");
		System.out.println("-------------------------------------------------------------");
		
		int Rec_Pkt_Size, Rem_Buc_content = 0,Buc_Content = 0;
		
		for(int i = 0;i<num; i++) {
			Rec_Pkt_Size = pkts[i];
			Buc_Content = Rec_Pkt_Size + Rem_Buc_content;
	
			if(Buc_Content > b_size) {
				Buc_Content = Rem_Buc_content;
				Rem_Buc_content = Buc_Content - op_rate;
				if(Rem_Buc_content<0)
					Rem_Buc_content=0;
				System.out.println(Rec_Pkt_Size + "    \t   " + Buc_Content + "     \t    " + "   Rej  \t  " + Rem_Buc_content);
			}
			else {
				//total = Rem_Buc_content;
				Rem_Buc_content = Buc_Content - op_rate;
				if(Rem_Buc_content<0)
					Rem_Buc_content=0;
				System.out.println(Rec_Pkt_Size + "     \t   " + Buc_Content + "     \t    " + "   Acc  \t  " + Rem_Buc_content);
			}
		}
		while(Rem_Buc_content >0) {
			Buc_Content = Rem_Buc_content;
			Rem_Buc_content = Rem_Buc_content - op_rate;
	
			if(Rem_Buc_content<0) {
				Rem_Buc_content =0;
			}
			System.out.println("--   " + "  \t   " + Buc_Content + "     \t    " + "   -- \t  " + Rem_Buc_content);

		}
	}

}
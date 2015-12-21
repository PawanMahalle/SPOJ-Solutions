import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
	
		boolean[] composite = new boolean[10000];
		
		for(int i=2;i<=100;i++){
			int k = 2;
			while((k * i) < 10000 ){
				composite[k*i] = true;
				k++;
			}
		}
		
		while(test-- > 0){
	
			Map<String, Boolean> map = new HashMap<String, Boolean>();
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n1 = st.nextToken();
			String n2 = st.nextToken();
			boolean found = false;
			Queue<StringHolder> queue = new LinkedList<StringHolder>();
			StringHolder intializerObj = new StringHolder(n1,0);
			queue.add(intializerObj);
			map.put(n1, true);
			while(!queue.isEmpty() && !found){
				StringHolder stringHolder = queue.remove();
				if(stringHolder.toString().equals(n2)){
					System.out.println(stringHolder.level);
					found = true;
					break;
				}else{
					for(int value=0;value<=9 && !found;value++){
						for(int index=0;index<4;index++){
							StringHolder newStringHolder = new StringHolder(stringHolder.toString(), stringHolder.level+1);
							if(index != 0 || value != 0){
								newStringHolder.update(index, String.valueOf(value));
							}
							if(!map.containsKey(newStringHolder.toString()) && composite[Integer.parseInt(newStringHolder.toString())] == false){
								map.put(newStringHolder.toString(), true);
								queue.add(newStringHolder);
								if(newStringHolder.toString().equals(n2)){
									System.out.println(newStringHolder.level);
									found = true;
									break;
								}
							}
						}
					}
				}
			}//end of while
			if(found == false){
				System.out.println("Impossible");
			}
		}
			
	}
}

class StringHolder{
	
	String[] digit = new String[4];
	int level;
	
	public StringHolder(String n1, int i)
	{	
		digit[0] = n1.substring(0,1);
		digit[1] = n1.substring(1,2);
		digit[2] = n1.substring(2,3);
		digit[3] = n1.substring(3,4);
		level = i;
	}
	
	void update(int i, String value){
		digit[i] = value;
	}	

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(digit[0]);
		sb.append(digit[1]);
		sb.append(digit[2]);
		sb.append(digit[3]);
		return sb.toString();
	}
}

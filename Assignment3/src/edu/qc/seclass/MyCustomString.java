package edu.qc.seclass;


public class MyCustomString implements MyCustomStringInterface {
	private String currentString;

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		if(currentString.isEmpty()) {
			return null;
		}else {
			return currentString;
		}
	}

	@Override
	public void setString(String currentString) {
		// TODO Auto-generated method stub
		this.currentString = currentString;
		
	}

	@Override
	public int countNumbers() {
		// TODO Auto-generated method stub
		char[] sarr = this.currentString.toCharArray();
		int count = 0;
		
		if(this.currentString.isEmpty()) {
			return 0;
		}
		else if(currentString == null){
			 throw new NullPointerException("Null pointer exception occurs");
		}
		else if(Character.isDigit(sarr[0])){
			count++; 
		}
			
		else {
		        for(int i=1; i<sarr.length; i++) {
		            try {
		            	
		            	if (Character.isDigit(sarr[i])) {
		            		if (!Character.isDigit(sarr[i-1]))
		            			count++;
		            	}
		            } catch(NumberFormatException e) {
		            	throw new NumberFormatException("Something went wrong");
		            }
		        }
		}
		
		return count;
	}

	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		int start = 1;
		StringBuffer sBuffer = new StringBuffer();
		
		if(n <= 0) {
			throw new IllegalArgumentException("Illegal argument exception occurs");
		}
		else if(this.currentString.equals(null) && n>0) {
			throw new NullPointerException("Null pointer exception occurs");
		}
		else if(this.currentString.isEmpty() || this.currentString.length() < n) {
			return "";
		}
		
		
		if(startFromEnd == false) {
			while(start <= this.currentString.length()) {
				if (n*start-1 >= this.currentString.length()) break;
				sBuffer.append(this.currentString.charAt(n*start-1));
				start++;

			}
			return sBuffer.toString();
		}else{
			while(start <= this.currentString.length()) {
				int nIdx = this.currentString.length()-(n*start);
				if (nIdx < 0) break;
				sBuffer.append(this.currentString.charAt(nIdx));
				start++;
			}
			return sBuffer.reverse().toString();
		}
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		// TODO Auto-generated method stub
		
		if(startPosition > endPosition) {
			throw new IllegalArgumentException("Illegal argument exception occurs: startPosition > endPosition");
		}
		else if (startPosition <= endPosition)
		{
			if((startPosition <1) || (endPosition > this.currentString.length()-1)) 
			{
				throw new MyIndexOutOfBoundsException("Index is out of bound exception occurs");
			}
			else if((startPosition>0 && endPosition>0) && this.currentString==null) 
			{
				throw new NullPointerException("Null pointer exception occurs");
			}
			else {
				
				String[] arrayList = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
							
				StringBuffer sbCustomStringBuffer = new StringBuffer(currentString);
				
				for (int i=startPosition-1; i<endPosition; i++) {
					Character character = sbCustomStringBuffer.charAt(i);
					if (Character.isDigit(character)) {
						String string2 = sbCustomStringBuffer.substring(i+1, sbCustomStringBuffer.length());
						sbCustomStringBuffer.delete(i, sbCustomStringBuffer.length());
						sbCustomStringBuffer.append(arrayList[Character.getNumericValue(character)]);
						
						sbCustomStringBuffer.append(string2);
						endPosition += arrayList[Character.getNumericValue(character)].length()-1;
					}
				}

				this.currentString =  sbCustomStringBuffer.toString();
				
			}
		}
	}

}

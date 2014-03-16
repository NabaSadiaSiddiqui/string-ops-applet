import java.applet.*;
import java.awt.*;

public class StringOpsApplet extends Applet
{
	String usrInput;

	String reversedString;
	
	char[] engVowels = {'a', 'e', 'i', 'o', 'u'};	
	int[] vowelCount = new int [5];

	int numWords;

	@Override
	public void init()
	{
		//Fetch user's input string (stored in param.value)
		usrInput=getParameter("usrInput");

		//Set background color
		setBackground(new Color(15, 240, 180));
	}

	@Override
	public void start()
	{
		super.start();

		sCountVowels();
		sReverse();
		sCountWords();
	}

	@Override
	public void paint (Graphics g)
	{
		/*Render the string entered by the user*/
		//Set enclosing rectangle
		g.setColor(new Color(208, 62, 159));
		Rectangle currRectParam=g.getClipRect();
		g.fillRoundRect(20, 10, currRectParam.width-40, 50, 10, 10);
		//Print string prompt
		g.setColor(Color.white);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.drawString("Original string : ", 30, 40);
		//Print user-entered string
		g.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 20));
		g.drawString(usrInput, 220, 40);


		/*Print total number of words found in the string*/
		//Draw a wedge and an arrow to symbolize string reversal
		//Draw wedge
		g.setColor(new Color(255, 255, 4));
		g.fillArc(35, 70, 50, 50, 0, 315);
		//Draw arrow
		g.setColor(Color.red);
		g.drawArc(50, 85, 40, 40, 10, -90);
		g.fillArc(81, 75, 30, 30, 225, 45);
		//Print reversed string
		g.setColor(Color.black);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		g.drawString("After", 130, 90);
		g.drawString("reversal", 115, 110);
		g.drawString("...", 135, 125);
		g.drawRect(230, 75, 230, 40);
		g.setColor(new Color(205, 205, 205));
		g.fillRect(230, 75, 230, 40);
		g.setColor(Color.black);
		g.drawString(reversedString, 240, 100);

		
		/*Print a summary of vowel statistics of the string*/
		//Set the table and heading
		g.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		g.drawRect(35, 140, 425, 140);
		g.setColor(new Color(245, 245, 220));
		g.fillRect(36, 141, 424, 139);
		g.setColor(Color.black);
		g.drawString(">> Vowel statistics", 40, 160);
		//Print vowels and corresponding counts
		g.setFont(new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 18));
		for(int i=0; i<5; i++)
		{
			int x=80;
			int y=185+i*20;
			String _output=Character.toString(engVowels[i])+" :    occurrences";
			g.drawString(_output, x, y);
		}
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		for(int i=0; i<5; i++)
		{
			int x=125;
			int y=185+i*20;
			String _output=Integer.toString(vowelCount[i]);
			g.drawString(_output, x, y);
		}
		
		/*Print the total number of words in the string*/
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		String _words;
		if(numWords==1)
			_words="word";
		else
			_words="words";
		String _output="The string you entered has "+Integer.toString(numWords)+" "+_words+".";
		g.drawString(_output, 35, 315);
		g.setColor(new Color(0, 0, 204));
		g.drawRect(350, 290, 30, 30);
	}

	private void sCountVowels()	//Sum the number of vowels in usrInput
	{
		char[] usrInputArr = usrInput.toCharArray();
		int strLen = usrInputArr.length;
		int numVowels = 5;
		int i;
		for(i=0; i<numVowels; i++){
			int j;
			char target = engVowels[i];
			for(j=0; j<strLen; j++){
				if(usrInputArr[j]==target){
					vowelCount[i]++;
				}
			}
		}
	}

	private void sReverse()		//Reverse the string usrInput
	{
		//Transform string to char array so its individual elements can be accessed
		char[] orgStrArr = this.usrInput.toCharArray();
		
		int strLen = orgStrArr.length;
		int counter;
	
		//Temporary array to store elements of usrInputArr starting from the other end
		char[] tmpArr = new char[strLen];
		
		for(counter=0; counter<strLen; counter++){
			tmpArr[counter]=orgStrArr[strLen - counter - 1];
		}

		//Create a new string from tmpArr
		reversedString = new String(tmpArr);
	}

	private void sCountWords()	//Sum the number of words in the string usrInput
	{
		String[] arrWords = usrInput.split(" ");
		numWords = arrWords.length;
	}
}

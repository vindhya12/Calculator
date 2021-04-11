import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;

class Calculator
{
	public static void main(String args[])
	{
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setSize(445,650);
		f.setLocation(200,50);
		f.setBackground(Color.black);		
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}

class FDemo extends JFrame implements ActionListener
{
	JTextField tx1;	
	JButton b[]=new JButton[20];
	
	int k=0;
	int x,y,w,h;
	String data[]={"B","C","1/x","sqrt","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	FDemo()
	{
		x=15;
		y=100;
		w=100;
		h=100;
		
		setLayout(null);
		Font f=new Font("",Font.BOLD,30);
		
		tx1=new JTextField();
		tx1.setBackground(Color.black);
		tx1.setForeground(Color.white);
		tx1.setSize(398,80);
		tx1.setLocation(15,10);
		tx1.setFont(f);
		//to start writting from right in calculator
		tx1.setHorizontalAlignment(JTextField.RIGHT);
		add(tx1);
		
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				b[k]=new JButton(data[k]);
				b[k].setBackground(Color.black);
				b[k].setForeground(Color.white);
				b[k].setSize(w,h);
				b[k].setLocation(x,y);
				b[k].setFont(f);
				add(b[k]);
				//Add ActionListener
				b[k].addActionListener(this);
				k++;
				x=x+100;
			}
			x=15;
			y=y+100;
			
		}
		/*
		b[0].setLabel("B");
		b[1].setLabel("C");
		b[2].setLabel("1/x");
		b[3].setLabel("sqrt");
		
		b[4].setLabel("7");
		b[5].setLabel("8");
		b[6].setLabel("9");
		b[7].setLabel("/");
		
		b[8].setLabel("4");
		b[9].setLabel("5");
		b[10].setLabel("6");
		b[11].setLabel("*");
		
		b[12].setLabel("1");
		b[13].setLabel("2");
		b[14].setLabel("3");
		b[15].setLabel("-");
		
		b[16].setLabel("0");
		b[17].setLabel(".");
		b[18].setLabel("=");
		b[19].setLabel("+");
		*/
		
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//B ->backslash code
		if(e.getSource()==b[0])
		{
			String s1=tx1.getText();
			tx1.setText(s1.substring(0,s1.length()-1));
		}
		//C ->all clear code
		else if(e.getSource()==b[1])
		{
			tx1.setText("");
		}
		//1/x -> to find 1/x of a given no.  code 
		else if(e.getSource()==b[2])
		{
			String s1=tx1.getText();
			double a=Double.parseDouble(s1);
			a=1/a;
			tx1.setText(""+a);
		}
		//sqrt -> to find sqrt of a given no. code
		else if(e.getSource()==b[3])
		{
			
			String s1=tx1.getText();
			double a=Double.parseDouble(s1);
			tx1.setText(""+Math.sqrt(a));
		}
		//= -> equal i.e. evaluate code
		else if(e.getSource()==b[18])
		{
			String s1=tx1.getText();
			
			ScriptEngineManager sem =new ScriptEngineManager();
			ScriptEngine se=sem.getEngineByName("js");
			
			try
			{
				tx1.setText(""+se.eval(s1));
			}catch(Exception exc){}
		}
			
		else
		{
			JButton b1=(JButton)e.getSource();
			String s5=tx1.getText()+b1.getLabel();
			tx1.setText(s5);
		}
		
		
	}
}



import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class ChatFrame extends JFrame {
	
	private JPanel messagePanel;
	private JPanel buttonPanel;
	
	private JTextArea LoLText;
	private JTextField sendMessage;
	
	private ButtonGroup buttonGroup;

	private JButton send, viewChamp;


	
	
	//Constructer for chat frame
	public ChatFrame()
	{
	    Container contentPane = getContentPane();						// Retrieve the content pane of the frame

		
		messagePanel = new JPanel();									// Add a panel for the text area
	   
		LoLText = new JTextArea(20,60);	    	
	    JScrollPane scrollPane = new JScrollPane(LoLText); 				// Create a scroll bar
	    LoLText.setEditable(false);										// Does not allow the text area to be edited

	    messagePanel.add(scrollPane);									// Make the panel with the text area Scrollable
	    contentPane.add(messagePanel,"Center");							// Add the message text area to the center of the frame

	    
	    

		buttonPanel = new JPanel();										// Create a new panel for the message box and buttons
		// TODO: Add a label, a text box, and the three buttons to the buttonPanel
		contentPane.add(buttonPanel,"South");							// Add the message box and button panel to the bottom of the frame
		
		buttonPanel.add(new JLabel("Message: "));
		sendMessage = new JTextField(40);
		buttonPanel.add(sendMessage);

		send = new JButton("Send");
		viewChamp = new JButton("View LoL Champions");
		
		buttonPanel.add(send);
		buttonPanel.add(viewChamp);
			
		
		
	    
	}
	
	
	
	
	
	
	
	
}

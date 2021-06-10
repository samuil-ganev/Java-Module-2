package maze;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MazeControl  extends JPanel{

	private MazePanel mazePanel = new MazePanel();
	
	private JButton findPathBtn = new JButton("Find Path");
	private JButton cleanPathBtn = new JButton("Reset");
	
	public MazeControl(){
		
		setLayout (new BorderLayout());
		add(mazePanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( findPathBtn) ;
		buttonPanel.add(cleanPathBtn) ;
		add(buttonPanel, BorderLayout .SOUTH) ;
		
		findPathBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mazePanel.findPath();
			}
		});
		
		cleanPathBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mazePanel.cleanPath();
			}
		});
	}
}

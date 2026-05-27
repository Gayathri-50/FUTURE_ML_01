import java.awt.*;
import java.awt.event.*;

public class AWTEmail extends Frame implements ActionListener {
    Button enter;
    TextField fname, lname, res;
    Label l1, l2, l3;

    AWTEmail() {
        super("Email Generation");
        
        l1 = new Label("Enter Firstname: ");
        l2 = new Label("Enter Lastname: ");
        l3 = new Label("Email: ");

        fname = new TextField(10);
        lname = new TextField(10);
        res = new TextField(10);
        res.setEditable(false);

        enter = new Button("Generate Email");
        enter.addActionListener(this);

        setLayout(new GridLayout(4, 2, 10, 10));
        setVisible(true);

        add(l1);
        add(fname);
        add(l2);
        add(lname);
        add(l3);
        add(res);
        add(enter);

        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == enter) {
                String f = fname.getText().trim();
                String l = lname.getText().trim();

                if (l.isEmpty() || f.isEmpty()) {
                    showDialog("Both fields are required!");
                    return;
                }

                if (l.length() < 2) {
                    showDialog("Last name must have at least 2 characters!");
                    return;
                }

                if (f.length() < 3) {
                    showDialog("First name must have at least 3 characters!");
                    return;
                }

                String r = f.substring(0, 3) + l.substring(l.length() - 2) + "@gmail.com";
                res.setText(r);
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    private void showDialog(String msg) {
        Dialog dialog = new Dialog(this, "Alert", true);
        dialog.setLayout(new FlowLayout());
        Label lbl = new Label(msg);
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        dialog.add(lbl);
        dialog.add(ok);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {
        new AWTEmail();
    }
}
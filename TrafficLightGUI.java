package Traffic;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficLightGUI extends JFrame {
    enum TrafficLight{
        RED("정지", 30), YELLOW("주의", 5), GREEN("진행", 20);
        private String sign;
        private int duaration;
        TrafficLight(String sign, int duration){
            this.sign = sign;
            this.duaration = duration;
        }
        TrafficLight nextLight(){
            switch(this){
                case RED: return GREEN;
                case GREEN: return YELLOW;
                case YELLOW: return RED;
                default: return RED;
            }
        }

    }// end of Enum TrafficLight

    LightPanel LightPanel = new LightPanel();
    JLabel Label = new JLabel();
    TrafficLight current = TrafficLight.RED;

    TrafficLightGUI() {
        setTitle("교통신호등 1-3");
        setSize(250, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //신호 표시 영역
        add(LightPanel, BorderLayout.CENTER);

        //상태 텍스트 표시
        Label.setFont(new Font("Selif", Font.BOLD, 18));
        add(Label, BorderLayout.SOUTH);

        updateLight(); //RED

        //일정 시간마다 신호 변경(2초)

        Timer time = new Timer();
        time.schedule(new TimerTask(){
            @Override
            public void run(){
                current = current.nextLight();
                updateLight();
            }
        }, 3, 2000);


        setVisible(true);
    }
    void updateLight(){
        LightPanel.repaint();
        Label.setText("현재 신호 : " + current.sign);
    }
    class LightPanel extends JPanel{
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            int x = 85;
            int y = 50;
            int size = 60;

            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(50, 30, 130, 260, 30, 300);

            //RED
            g.setColor(current == TrafficLight.RED ? Color.RED:Color.GRAY);
            g.fillOval(x, y, size, size);

            //YELLOW
            g.setColor(current == TrafficLight.YELLOW ? Color.YELLOW: Color.GRAY);
            g.fillOval(x, y + 80, size, size);

            //GREEN
            g.setColor(current == TrafficLight.GREEN ? Color.GREEN:Color.GRAY);
            g.fillOval(x, y + 160, size, size);



        }
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(TrafficLightGUI::new);
    }
}


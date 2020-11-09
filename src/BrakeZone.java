/* Started 13/05/2020 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BrakeZone extends Application
{
    @Override   // override the main method in Application class
    public void start(Stage primaryStage)
    {
        GridPane gp1 = new GridPane();
        // gp1.setGridLinesVisible(true);

        gp1.setAlignment(Pos.TOP_LEFT);
        gp1.setHgap(10);
        gp1.setVgap(1);
        gp1.setPadding(new Insets(10,10,10,20));
        gp1.setStyle("-fx-background-color: WHITE");

        GridPane gp2 = new GridPane();
        // gp2.setGridLinesVisible(true);

        gp2.setAlignment(Pos.TOP_LEFT);
        gp2.setHgap(10);
        gp2.setVgap(1);
        gp2.setPadding(new Insets(10,10,20,20));
        gp2.setStyle("-fx-background-color: WHITE");

        BorderPane bp = new BorderPane();
        bp.setPrefWidth(800);
        bp.setPrefHeight(500);
        bp.setCenter(gp1);
        bp.setBottom(gp2);

        /* FlowPane for producing chequered flag banner */
        FlowPane checkers = new FlowPane();

        for (int row=0; row<3; row++)
        {
            for (int col=0; col<(int)bp.getPrefWidth()/10; col++)
            {
                // create squares
                Rectangle square = new Rectangle();
                square.setHeight(10);
                square.setWidth(10);

                if (row%2 == 0 && col%2 == 0)
                {
                    square.setFill(Color.WHITE);
                }
                else if (row%2 != 0 && col%2 != 0)
                {
                    square.setFill(Color.WHITE);
                }
                else
                {
                    square.setFill(Color.BLACK);
                }

                checkers.getChildren().add(square);
            }
        }

        bp.setTop(checkers);

        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");

        Label mainLbl = new Label("Brake Performance Calculation\n & Recommendation Program");
        Label reportNoLbl = new Label("Report No.");
        Label reportNameLbl = new Label("Report Name");
        Label dateLbl = new Label("Date Created");
        Label vehNameLbl = new Label("Vehicle Name");
        Label authorLbl = new Label("Compiled By");
        Label vehClassLbl = new Label("Vehicle Class");
        Label vehMassLbl = new Label("Vehicle Mass");
        Label massTotalLbl = new Label("TOTAL");
        Label massFrontLbl = new Label("Font Axle");
        Label massRearLbl = new Label("Rear Axle");
        Label cogLbl = new Label("C of G Height");
        Label kgLbl = new Label("kg");
        Label gvwLbl = new Label("GVW / Laden");
        Label llwLbl = new Label("LLW / Unladen");
        Label gtwLbl = new Label("GTW / Trailer");
        Label foundationBrakeLbl = new Label("Foundation Brake Parameters");

        mainLbl.setFont(Font.font("Consolas"));
        reportNoLbl.setFont(Font.font("Consolas"));
        reportNameLbl.setFont(Font.font("Consolas"));
        dateLbl.setFont(Font.font("Consolas"));
        authorLbl.setFont(Font.font("Consolas"));
        vehNameLbl.setFont(Font.font("Consolas"));
        vehClassLbl.setFont(Font.font("Consolas"));
        vehMassLbl.setFont(Font.font("Consolas"));
        massTotalLbl.setFont(Font.font("Consolas"));
        massFrontLbl.setFont(Font.font("Consolas"));
        massRearLbl.setFont(Font.font("Consolas"));
        cogLbl.setFont(Font.font("Consolas"));
        kgLbl.setFont(Font.font("Consolas"));
        gvwLbl.setFont(Font.font("Consolas"));
        llwLbl.setFont(Font.font("Consolas"));
        gtwLbl.setFont(Font.font("Consolas"));
        foundationBrakeLbl.setFont(Font.font("Consolas"));


        Text breakTxt = new Text("----");
        breakTxt.setFont(Font.font("Consolas"));

        TextField reportNoTf = new TextField();
        TextField reportNameTf = new TextField();
        TextField dateTf = new TextField(dtf.format(date));
        TextField vehNameTf = new TextField();
        TextField authorTf = new TextField();

        ComboBox<String> vehClassCb = new ComboBox<>();
        vehClassCb.getItems().addAll("M1","M2","M3","N1","N2","N3");
        vehClassCb.setStyle("-fx-font: 12px Consolas");


        TextField massGVWTotalTf = new TextField("0.0");
        TextField massGVWFrontTf = new TextField("0.0");
        TextField massGVWRearTf = new TextField("0.0");
        TextField massLLWTotalTf = new TextField("0.0");
        TextField massLLWFrontTf = new TextField("0.0");
        TextField massLLWRearTf = new TextField("0.0");
        TextField massGTWTotalTf = new TextField("0.0");
        TextField cogLLW_Tf = new TextField("0.0");
        TextField cogGVW_Tf = new TextField("0.0");
        TextField pedalRatioTf = new TextField();
        TextField pedalEffTf = new TextField();
        TextField pedalTravelTf = new TextField();


        reportNoTf.setFont(Font.font("Consolas"));
        reportNameTf.setFont(Font.font("Consolas"));
        dateTf.setFont(Font.font("Consolas"));
        vehNameTf.setFont(Font.font("Consolas"));
        authorTf.setFont(Font.font("Consolas"));

        massGVWTotalTf.setFont(Font.font("Consolas"));
        massGVWFrontTf.setFont(Font.font("Consolas"));
        massGVWRearTf.setFont(Font.font("Consolas"));
        massLLWTotalTf.setFont(Font.font("Consolas"));
        massLLWFrontTf.setFont(Font.font("Consolas"));
        massLLWRearTf.setFont(Font.font("Consolas"));
        massGTWTotalTf.setFont(Font.font("Consolas"));
        cogLLW_Tf.setFont(Font.font("Consolas"));
        cogGVW_Tf.setFont(Font.font("Consolas"));
        pedalRatioTf.setFont(Font.font("Consolas"));
        pedalEffTf.setFont(Font.font("Consolas"));
        pedalTravelTf.setFont(Font.font("Consolas"));

        massGTWTotalTf.setPrefWidth(20);

        massGVWTotalTf.setAlignment(Pos.CENTER_RIGHT);
        massGVWFrontTf.setAlignment(Pos.CENTER_RIGHT);
        massGVWRearTf.setAlignment(Pos.CENTER_RIGHT);
        massLLWTotalTf.setAlignment(Pos.CENTER_RIGHT);
        massLLWFrontTf.setAlignment(Pos.CENTER_RIGHT);
        massLLWRearTf.setAlignment(Pos.CENTER_RIGHT);
        massGTWTotalTf.setAlignment(Pos.CENTER_RIGHT);
        cogGVW_Tf.setAlignment(Pos.CENTER_RIGHT);
        cogLLW_Tf.setAlignment(Pos.CENTER_RIGHT);
        pedalRatioTf.setAlignment(Pos.CENTER_RIGHT);
        pedalEffTf.setAlignment(Pos.CENTER_RIGHT);
        pedalTravelTf.setAlignment(Pos.CENTER_RIGHT);

        ImageView smdLogo = new ImageView("image/SMD_2.png");
        // smdLogo.setFitHeight(100);
        // smdLogo.setPreserveRatio(true);


        gp1.add(mainLbl,0,0);
        gp1.add(smdLogo,4,0);
        gp1.add(reportNoLbl,2,2);
        gp1.add(reportNoTf,3,2);
        gp1.add(reportNameLbl,2,3);
        gp1.add(reportNameTf,3,3);
        gp1.add(dateLbl,2,4);
        gp1.add(dateTf,3,4);
        gp1.add(authorLbl,2,5);
        gp1.add(authorTf,3,5);
        gp1.add(breakTxt,1,6);
        gp1.add(vehNameLbl,0,7);
        gp1.add(vehNameTf,1,7);
        gp1.add(vehClassLbl,0,8);
        gp1.add(vehClassCb,1,8);

        gp2.add(vehMassLbl,0,0);
        gp2.add(massTotalLbl,0,1);
        gp2.add(massFrontLbl,0,2);
        gp2.add(massRearLbl,0,3);
        gp2.add(foundationBrakeLbl,4,7);

        gp2.add(massGVWTotalTf,1,1);
        gp2.add(massGVWFrontTf,1,2);
        gp2.add(massGVWRearTf,1,3);
        gp2.add(cogGVW_Tf,1,5);
        gp2.add(cogLLW_Tf,3,5);

        gp2.add(massLLWTotalTf,3,1);
        gp2.add(massLLWFrontTf,3,2);
        gp2.add(massLLWRearTf,3,3);

        gp2.add(massGTWTotalTf,5,1);

        gp2.add(pedalRatioTf,1,8);
        gp2.add(pedalEffTf,1,9);
        gp2.add(pedalTravelTf,1,10);

        gp2.add(gvwLbl,1,0);
        gp2.add(llwLbl,3,0);
        gp2.add(gtwLbl,5,0);
        gp2.add(labelFormat("kg"),2,1);
        gp2.add(labelFormat("kg"),2,2);
        gp2.add(labelFormat("kg"),2,3);
        gp2.add(labelFormat("kg"),4,1);
        gp2.add(labelFormat("kg"),4,2);
        gp2.add(labelFormat("kg"),4,3);
        gp2.add(labelFormat("kg"),6,1);
        gp2.add(labelFormat("C of G Height"),0,5);
        gp2.add(labelFormat("mm"),2,5);
        gp2.add(labelFormat("mm"),4,5);

        gp2.add(new Line(0,0,100,0),0,6);
        gp2.add(labelFormat("Brake Pedal"),0,7);
        gp2.add(labelFormat("Ratio"),0,8);
        gp2.add(labelFormat("Efficiency"),0,9);
        gp2.add(labelFormat("Reqd. Travel"),0,10);
        gp2.add(labelFormat(": 1"),2,8);
        gp2.add(labelFormat("%"),2,9);
        gp2.add(labelFormat("mm"),2,10);


        gp2.setOnMousePressed(e -> {
            massGVWTotal = Double.parseDouble(massGVWTotalTf.getText());
            massGVWFront = Double.parseDouble(massGVWFrontTf.getText());
            massLLWTotal = Double.parseDouble(massLLWTotalTf.getText());
            massLLWFront = Double.parseDouble(massLLWFrontTf.getText());

            massGVWRear = setMassRear(massGVWTotal,massGVWFront);
            massLLWRear = setMassRear(massLLWTotal,massLLWFront);

            massGVWRearTf.setText(String.valueOf(massGVWRear));
            massLLWRearTf.setText(String.valueOf(massLLWRear));

            massGVWTotalTf.setText(String.format("%.1f",Double.parseDouble(massGVWTotalTf.getText())));
            massGVWFrontTf.setText(String.format("%.1f",Double.parseDouble(massGVWFrontTf.getText())));
            massGVWRearTf.setText(String.format("%.1f",Double.parseDouble(massGVWRearTf.getText())));
            cogGVW_Tf.setText(String.format("%.1f",Double.parseDouble(cogGVW_Tf.getText())));
        });

        Scene scene = new Scene(bp);

        primaryStage.setTitle("BrakeZone");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static double setMassRear(double massTotal, double massFront)
    {
        double massRear = massTotal - massFront;
        return massRear;
    }

    static double massGVWTotal;
    static double massGVWFront;
    static double massGVWRear;

    static double massLLWTotal;
    static double massLLWFront;
    static double massLLWRear;

    static Label labelFormat(String labelName)
    {
        Label label = new Label(labelName);
        label.setFont(Font.font("Consolas"));

        return label;
    }
}



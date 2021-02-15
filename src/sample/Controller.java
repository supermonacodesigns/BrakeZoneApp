package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {


    public GridPane gp2;

    public FlowPane checkersInputPage;
    public FlowPane checkersOutputPage;

    /* Variables */
    /* **************************************** */
    public static double discDiaFront;
    public static double padHeightFront;

    public static String reportNo;
    public static String reportName;
    public static String dateCreated;
    public static String vehicleName;
    public static String compiledBy;
    public static String vehicleClass = "N2";

    public BrakeInputs brakeInputs = new BrakeInputs(reportNo, reportName, dateCreated, vehicleClass);

    /* **************************************** */

    /* TextFields */
    /* **************************************** */
    public TextField massLLWTotalTf;
    public TextField massLLWFrontTf;
    public TextField massLLWRearTf;
    public TextField cogLLW_Tf;

    public TextField massGVWTotalTf;
    public TextField massGVWFrontTf;
    public TextField massGVWRearTf;
    public TextField cogGVW_Tf;

    public TextField d1FrontTf;
    public TextField d2FrontTf;
    public TextField d3FrontTf;
    public TextField d4FrontTf;

    public TextField d1RearTf;
    public TextField d2RearTf;
    public TextField d3RearTf;
    public TextField d4RearTf;

    public TextField d1ParkTf;
    public TextField d2ParkTf;

    public TextField brakesPerAxleFrontTf;
    public TextField brakesPerAxleRearTf;
    public TextField brakesPerAxleParkTf;

    public TextField areaPerBrakeFrontTf;
    public TextField areaPerBrakeRearTf;
    public TextField areaPerBrakeParkTf;

    public TextField areaPerAxleFrontTf;
    public TextField areaPerAxleRearTf;

    public TextField discDiaFrontTf;
    public TextField discDiaRearTf;
    public TextField discDiaParkTf;

    public TextField discThkFrontTf;
    public TextField discThkRearTf;
    public TextField discThkParkTf;

    public TextField padHeightFrontTf;
    public TextField padHeightRearTf;
    public TextField padHeightParkTf;

    public TextField padAreaFrontTf;
    public TextField padAreaRearTf;
    public TextField padAreaParkTf;

    public TextField muDynamicFrontTf;
    public TextField muDynamicRearTf;
    public TextField muDynamicParkTf;
    public TextField muStaticParkTf;

    public TextField effRadiusFrontTf;
    public TextField effRadiusRearTf;
    public TextField effRadiusParkTf;

    public TextField ratioFrontTf;
    public TextField ratioRearTf;

    public TextField masterCylDiaTf;
    public TextField masterCylStrokeTf;
    public TextField masterCylAreaTf;

    public TextField pedalRatioTf;
    public TextField pedalMinTravelTf;
    public TextField pedalEfficiencyTf;

    public TextField tyreWidthTf;
    public TextField tyreProfileTf;
    public TextField wheelSizeTf;
    public TextField tyreRadiusCalculatedTf;

    public TextField reportNoTf;
    public TextField reportNameTf;
    public TextField dateTf;
    public TextField vehicleNameTf;
    public TextField compiledByTf;
    /* **************************************** */

    /* Labels */
    /* **************************************** */
    public Label reportNoLabel;
    public Label reportNameLabel;
    public Label dateCreatedLabel;
    public Label vehicleNameLabel;
    public Label vehicleClassLabel;
    public Label compiledByLabel;
    /* **************************************** */


    /* ComboBoxes */
    /* **************************************** */
    public ComboBox<String> vehClassCb;
    public ComboBox<String> circuitSplitCb;
    /* **************************************** */

    public void drawCheckers(FlowPane fp) {
        for (int row=0; row<3; row++)
        {
            for (int col=0; col<800/10; col++)
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

                fp.getChildren().add(square);
            }
        }
    }

    @FXML
    public void initialize() {
        drawCheckers(checkersInputPage);
        drawCheckers(checkersOutputPage);
        setDateTf();
        initializeFocusListeners();
        refresh();

    }

    public void refresh() {
        updateMassLLWRear();
        updateMassGVWRear();

        setBrakeAreaFront();
        setBrakeAreaRear();
        setBrakeAreaPark();

        setEffRadiusFrontTf();
        setEffRadiusRearTf();
        setEffRadiusParkTf();

        setRatioTf();

        setMasterCylAreaTf();

        setPedalMinTravelTf();

        setTyreRadius();

        setReportNo();
        setReportName();
        setDateCreated();
        setVehicleName();
        setCompiledBy();
        setVehicleClass();
    }

    public void updateMassGVWRear() {
        massGVWRearTf.setText(
                String.format("%.1f",Double.parseDouble(massGVWTotalTf.getText())
                        - Double.parseDouble(massGVWFrontTf.getText())));

        massGVWTotalTf.setText(String.format("%.1f",Double.parseDouble(massGVWTotalTf.getText())));
        massGVWFrontTf.setText(String.format("%.1f",Double.parseDouble(massGVWFrontTf.getText())));
    }

    public void updateMassLLWRear() {
        massLLWRearTf.setText(
                String.format("%.1f",Double.parseDouble(massLLWTotalTf.getText())
                        - Double.parseDouble(massLLWFrontTf.getText())));

        massLLWTotalTf.setText(String.format("%.1f",Double.parseDouble(massLLWTotalTf.getText())));
        massLLWFrontTf.setText(String.format("%.1f",Double.parseDouble(massLLWFrontTf.getText())));
    }

    public void setDataVehClass() {
        vehClassCb.getItems().addAll(
                "M1","M2","M3","N1","N2","N3"
        );
    }

    public void setDataCircuitSplit() {
        circuitSplitCb.getItems().addAll(
                "II","X","HI","LL","HH"
        );
    }

    public void setBrakeAreaFront() {
        double d1 = 0;
        double d2 = 0;
        double d3 = 0;
        double d4 = 0;

        try  {
            d1 = Double.parseDouble(d1FrontTf.getText());
            d1FrontTf.setText(String.format("%.1f",Double.parseDouble(d1FrontTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d1 front is not Double format");
        }

        try  {
            d2 = Double.parseDouble(d2FrontTf.getText());
            d2FrontTf.setText(String.format("%.1f",Double.parseDouble(d2FrontTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d2 front is not Double format");
        }

        try  {
            d3 = Double.parseDouble(d3FrontTf.getText());
            d3FrontTf.setText(String.format("%.1f",Double.parseDouble(d3FrontTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d3 front is not Double format");
        }

        try  {
            d4 = Double.parseDouble(d4FrontTf.getText());
            d4FrontTf.setText(String.format("%.1f",Double.parseDouble(d4FrontTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d4 front is not Double format");
        }

        areaPerBrakeFrontTf.setText(
                String.format("%.1f",
                        (
                                (Math.pow(d1 / 2, 2) * Math.PI)
                                        + (Math.pow(d2 / 2, 2) * Math.PI)
                                        + (Math.pow(d3 / 2, 2) * Math.PI)
                                        + (Math.pow(d4 / 2, 2) * Math.PI)
                        ) / 100
                )
        );

        areaPerAxleFrontTf.setText(String.format("%.1f",
                (Double.parseDouble(areaPerBrakeFrontTf.getText())) * Integer.parseInt(brakesPerAxleFrontTf.getText())));

    }

    public void setBrakeAreaRear() {
        double d1 = 0;
        double d2 = 0;
        double d3 = 0;
        double d4 = 0;

        try  {
            d1 = Double.parseDouble(d1RearTf.getText());
            d1RearTf.setText(String.format("%.1f",Double.parseDouble(d1RearTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d1 rear is not Double format");
        }

        try  {
            d2 = Double.parseDouble(d2RearTf.getText());
            d2RearTf.setText(String.format("%.1f",Double.parseDouble(d2RearTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d2 rear is not Double format");
        }

        try  {
            d3 = Double.parseDouble(d3RearTf.getText());
            d3RearTf.setText(String.format("%.1f",Double.parseDouble(d3RearTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d3 rear is not Double format");
        }

        try  {
            d4 = Double.parseDouble(d4RearTf.getText());
            d4RearTf.setText(String.format("%.1f",Double.parseDouble(d4RearTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d4 rear is not Double format");
        }

        areaPerBrakeRearTf.setText(
                String.format("%.1f",
                        (
                                (Math.pow(d1 / 2, 2) * Math.PI)
                                        + (Math.pow(d2 / 2, 2) * Math.PI)
                                        + (Math.pow(d3 / 2, 2) * Math.PI)
                                        + (Math.pow(d4 / 2, 2) * Math.PI)
                        ) / 100
                )
        );

        areaPerAxleRearTf.setText(String.format("%.1f",
                (Double.parseDouble(areaPerBrakeRearTf.getText())) * Integer.parseInt(brakesPerAxleRearTf.getText())));
    }

    public void setBrakeAreaPark() {
        double d1 = 0;
        double d2 = 0;

        try {
            d1 = Double.parseDouble(d1ParkTf.getText());
            d1ParkTf.setText(String.format("%.1f",Double.parseDouble(d1ParkTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d1 park is not Double format");
        }

        try {
            d2 = Double.parseDouble(d2ParkTf.getText());
            d2ParkTf.setText(String.format("%.1f",Double.parseDouble(d2ParkTf.getText())));
        } catch (NumberFormatException e) {
            System.out.println("d2 park is not Double format");
        }

        areaPerBrakeParkTf.setText(String.format("%.1f",
                (
                        (Math.pow(d1 / 2, 2) * Math.PI)
                                + (Math.pow(d2 / 2, 2) * Math.PI)
                ) / 100
                )
        );
    }

    public void setEffRadiusFrontTf() {

        effRadiusFrontTf.setText(String.format("%.1f",
                (
                        Double.parseDouble(discDiaFrontTf.getText()) / 2)
                        - (Double.parseDouble(padHeightFrontTf.getText()) / 2)
                        - 1.5
                )
        );

        formatTextFieldDouble(discDiaFrontTf, 1);
        formatTextFieldDouble(padHeightFrontTf, 1);
    }

    public void setEffRadiusRearTf() {
        effRadiusRearTf.setText(String.format("%.1f",
                (
                        Double.parseDouble(discDiaRearTf.getText()) / 2)
                        - (Double.parseDouble(padHeightRearTf.getText()) / 2)
                        - 1.5
                )
        );

        formatTextFieldDouble(discDiaRearTf, 1);
        formatTextFieldDouble(padHeightRearTf, 1);

    }

    public void setEffRadiusParkTf() {
        effRadiusParkTf.setText(String.format("%.1f",
                (
                        Double.parseDouble(discDiaParkTf.getText()) / 2)
                        - (Double.parseDouble(padHeightParkTf.getText()) / 2)
                        - 1.5
                )
        );
    }

    public void setRatioTf() {
        ratioFrontTf.setText(String.format("%.1f",
                (
                        (
                                (     Double.parseDouble(areaPerAxleFrontTf.getText())
                                        * Double.parseDouble(effRadiusFrontTf.getText())
                                        * Double.parseDouble(muDynamicFrontTf.getText())    )
                                        /
                                        ((     Double.parseDouble(areaPerAxleFrontTf.getText())
                                                * Double.parseDouble(effRadiusFrontTf.getText())
                                                * Double.parseDouble(muDynamicFrontTf.getText())    )
                                                +
                                                (Double.parseDouble(areaPerAxleRearTf.getText())
                                                        * Double.parseDouble(effRadiusRearTf.getText())
                                                        * Double.parseDouble(muDynamicRearTf.getText())     )
                                        )
                        )
                ) * 100
        ));

        ratioRearTf.setText(String.format("%.1f",
                (
                        (
                                (     Double.parseDouble(areaPerAxleRearTf.getText())
                                        * Double.parseDouble(effRadiusRearTf.getText())
                                        * Double.parseDouble(muDynamicRearTf.getText())    )
                                        /
                                        ((     Double.parseDouble(areaPerAxleFrontTf.getText())
                                                * Double.parseDouble(effRadiusFrontTf.getText())
                                                * Double.parseDouble(muDynamicFrontTf.getText())    )
                                                +
                                                (Double.parseDouble(areaPerAxleRearTf.getText())
                                                        * Double.parseDouble(effRadiusRearTf.getText())
                                                        * Double.parseDouble(muDynamicRearTf.getText())     )
                                        )
                        )
                ) * 100
        ));

        formatTextFieldDouble(effRadiusFrontTf, 1);
        formatTextFieldDouble(effRadiusRearTf, 1);
        formatTextFieldDouble(muDynamicFrontTf, 2);
        formatTextFieldDouble(muDynamicRearTf, 2);
    }

    public void setDateTf() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        LocalDate date = LocalDate.now();
        dateTf.setText(dtf.format(date));
    }

    public void setMasterCylAreaTf() {
        masterCylAreaTf.setText(String.format("%.1f",
                (Math.PI) *
                        (Math.pow(((Double.parseDouble(masterCylDiaTf.getText())) / 2),2))
        ));

        formatTextFieldDouble(masterCylDiaTf, 1);
    }

    public void setPedalMinTravelTf() {
        pedalMinTravelTf.setText(String.format("%.1f",
                (Double.parseDouble(masterCylStrokeTf.getText()) * (Double.parseDouble(pedalRatioTf.getText()))
                )));

        formatTextFieldDouble(pedalRatioTf, 2);
        formatTextFieldDouble(masterCylStrokeTf, 1);
    }

    public void setTyreRadius() {
        tyreRadiusCalculatedTf.setText(String.format("%.1f",
                (Double.parseDouble(tyreWidthTf.getText()) * (Double.parseDouble(tyreProfileTf.getText()) / 100) * 2)
                        + (Double.parseDouble(wheelSizeTf.getText()) * 25.4)
        ));

        formatTextFieldDouble(tyreWidthTf,0);
        formatTextFieldDouble(tyreProfileTf,0);
        formatTextFieldDouble(wheelSizeTf,0);
    }

    public void formatTextFieldDouble(TextField tf, int significantDigits) {
        tf.setText(String.format("%."+significantDigits+"f", Double.parseDouble(tf.getText())));
    }

    public void setReportNo() {
        brakeInputs.setReportNo(reportNoTf.getText());
        reportNoLabel.setText(brakeInputs.getReportNo());
    }

    public void setReportName() {
        brakeInputs.setReportName(reportNameTf.getText());
        reportNameLabel.setText(brakeInputs.getReportName());
    }

    public void setDateCreated() {
        brakeInputs.setDateCreated(dateTf.getText());
        dateCreatedLabel.setText(brakeInputs.getDateCreated());
    }

    public void setVehicleName() {
        brakeInputs.setVehicleName(vehicleNameTf.getText());
        vehicleNameLabel.setText(brakeInputs.getVehicleName());
    }

    public void setCompiledBy() {
        brakeInputs.setCompiledBy(compiledByTf.getText());
        compiledByLabel.setText(brakeInputs.getCompiledBy());
    }

    public void setVehicleClass() {
        if (vehClassCb.getValue() == null) {
            vehicleClassLabel.setText(vehicleClass);
        }
        else {
            brakeInputs.setVehicleClass(vehClassCb.getValue());
            vehicleClassLabel.setText(brakeInputs.getVehicleClass());
        }
    }


    /*   Test method to dynamically update the contents of a text field whilst typing.
     *   Works, but has undesirable side effects, including updating cells with negative values
     *   whilst the new input value is being typed. And the current method of formatting the cell to 1 DP
     *   when the output value is updated prevents completion of typing in the input field.

    public void runListeners() {
        discDiaFrontTf.textProperty().addListener((observable, oldValue, newValue) ->
                setEffRadiusFrontTf());

        padHeightFrontTf.textProperty().addListener((observable, oldValue, newValue) ->
                setEffRadiusFrontTf());

    }
     */


    public void addFocusListener(TextField tf) {
        tf.focusedProperty().addListener((observable, oldValue, newValue) -> refresh());
        tf.setOnAction(e -> refresh());
    }

    public void addFocusListener(ComboBox<String> cb) {
        cb.focusedProperty().addListener((observable, oldValue, newValue) -> refresh());
        cb.setOnAction(e -> refresh());
    }

    public void initializeFocusListeners() {
        addFocusListener(massLLWFrontTf);
        addFocusListener(massLLWTotalTf);

        addFocusListener(massGVWFrontTf);
        addFocusListener(massGVWTotalTf);

        addFocusListener(tyreWidthTf);
        addFocusListener(tyreProfileTf);
        addFocusListener(wheelSizeTf);

        addFocusListener(d1FrontTf);
        addFocusListener(d2FrontTf);
        addFocusListener(d3FrontTf);
        addFocusListener(d4FrontTf);

        addFocusListener(d1RearTf);
        addFocusListener(d2RearTf);
        addFocusListener(d3RearTf);
        addFocusListener(d4RearTf);

        addFocusListener(d1ParkTf);
        addFocusListener(d2ParkTf);

        addFocusListener(brakesPerAxleFrontTf);
        addFocusListener(brakesPerAxleRearTf);
        addFocusListener(brakesPerAxleParkTf);

        addFocusListener(discDiaFrontTf);
        addFocusListener(discDiaRearTf);
        addFocusListener(discDiaParkTf);

        addFocusListener(padHeightFrontTf);
        addFocusListener(padHeightRearTf);
        addFocusListener(padHeightParkTf);

        addFocusListener(padAreaFrontTf);
        addFocusListener(padAreaRearTf);
        addFocusListener(padAreaParkTf);

        addFocusListener(muDynamicFrontTf);
        addFocusListener(muDynamicRearTf);
        addFocusListener(muDynamicParkTf);

        addFocusListener(pedalRatioTf);

        addFocusListener(masterCylDiaTf);
        addFocusListener(masterCylStrokeTf);

        addFocusListener(reportNoTf);
        addFocusListener(reportNameTf);
        addFocusListener(vehicleNameTf);
        addFocusListener(compiledByTf);
        addFocusListener(vehClassCb);
    }


}

package Utilities;

import GUI.DialogoGuardarConsola;
import GUI.MainGUI;
import GUI.CambiarRutaExperimento;
import GUI.CreateTaskGUI;
import GUI.CreateDirectoryGUI;
import GUI.CreateClassifierGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandra
 */
public final class WindowsInstances {
    public static MainGUI mainGUI = new MainGUI();
    public static CreateDirectoryGUI createDirectoryGUI = new CreateDirectoryGUI();
    public static CreateClassifierGUI createClasificadorGUI = new CreateClassifierGUI();
    public static CreateTaskGUI createTareaGUI = new CreateTaskGUI();
    public static DialogoGuardarConsola dialogoGuardarConsola = new DialogoGuardarConsola();
    public static CambiarRutaExperimento cambiarRutaExperimento = new CambiarRutaExperimento();
    public static TreeTransferHandler claseCopiar = new TreeTransferHandler();
}

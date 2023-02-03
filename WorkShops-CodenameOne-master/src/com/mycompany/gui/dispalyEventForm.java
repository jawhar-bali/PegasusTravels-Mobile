/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Evenement;

import com.mycompany.services.ServiceEvenement;

import java.util.ArrayList;

/**
 *
 * @author rahma
 */
public class dispalyEventForm extends BaseForm {
   Form current;
    public dispalyEventForm(Resources res ) {
          super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
       
        getTitleArea().setUIID("Container");
        setTitle("Add Event");
        getContentPane().setScrollVisible(false);
       
       
        tb.addSearchCommand(e ->  {
           
        });
       
        Tabs swipe = new Tabs();
       
        Label s1 = new Label();
        Label s2 = new Label();
       
        addTab(swipe,s1, res.getImage("dar-nour-3.jpg"),"","",res);
       
        // Welcome current user
       
      //  System.out.println("user connecté id ="+ SessionManager.getId());
       
       
       
      //  System.out.println("user connecté username ="+ SessionManager.getUserName());
       
       // System.out.println("user connecté password ="+ SessionManager.getPassowrd());
       
      //  System.out.println("user connecté email ="+ SessionManager.getEmail());
       
       
       
       
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

      ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("liste des evenement ", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Maps", barGroup);
        liste.setUIID("SelectBar");
       
        RadioButton stat = RadioButton.createToggle("pdf", barGroup);
        stat.setUIID("SelectBar");
       
       
       
        RadioButton partage = RadioButton.createToggle("Ajouter", barGroup);
        partage.setUIID("SelectBar");
       Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
           dispalyEventForm a = new  dispalyEventForm(res);
           a.show();
            refreshTheme();
        });
       
       
         liste.addActionListener((e) -> {
              InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
     //     MapsAPIForm a1 = new MapsAPIForm();
          new MapsAPIForm();
       //    a1.show();
            refreshTheme();
        });
       
         
         
             
         stat.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
          StatistiquePieFormEvent a2 = new StatistiquePieFormEvent(res);
           a2.show();
         
            refreshTheme();
        });
//         Button pdf = new Button("PDF");
//                pdf.addActionListener(new ActionListener() {
//                                @Override
//                                public void actionPerformed(ActionEvent evt) {
//                                        
//                                            if (Dialog.show("Confirmation", "Voulez vous imprimer ces reunions en pdf ?", "Oui", "Annuler")) {
//                                                
//                                                              
//                                                                      
//                                                                      
//                                                                        Dialog.show("Success","imprimer",new Command("OK"));
//                                                                        new PDF(res).show();
//                                                                      
//                                                                  
//
//                                            }
//                                }
//                            });
//                         ct.add(pdf);
       
       
         
         
       
         partage.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
        AjoutEventForm a1 = new AjoutEventForm(res);
           a1.show();
          // StatistiquePieForm
         
            refreshTheme();
        });
       
         
       
       
       
       
       
       
       
       

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(4, mesListes, liste,stat, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
       
     

         
       
       
        //Appel affichage methode
        ArrayList<Evenement>list = ServiceEvenement.getInstance().getAllEvents();
               
               
       
        for(Evenement m : list ) {
//            
                   

     
 String urlImage ="Logo.png";//image statique pour le moment ba3d taw fi  videos jayin nwarikom image
           
       
           
             Image placeHolder = Image.createImage(120, 90);
             EncodedImage enc =  EncodedImage.createFromImage(placeHolder,false);
             URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
             
                addButton(urlim,m,res);
       
                ScaleImageLabel image = new ScaleImageLabel(urlim);
               
                Container containerImg = new Container();
               
                image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
       
       
   
   
   
   
   
   
        }
    }
     
       private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
       
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
       
       
       
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
       
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        Label overLay = new Label("","ImageOverlay");
       
       
        Container page1 =
                LayeredLayout.encloseIn(
                imageScale,
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
       
        swipe.addTab("",res.getImage("Logo.png"), page1);
       
       
       
       
    }
   
   
   
    public void bindButtonSelection(Button btn , Label l ) {
       
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
       
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }

    private void addButton(Image img, Evenement v, Resources res) {
       
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
       
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
       
       
        //kif nzidouh  ly3endo date mathbih fi codenamone y3adih string w y5alih f symfony dateTime w ytab3ni cha3mlt taw yjih
        Label nomTxt = new Label("nom : "+v.getNomevent(),"NewsTopLine2");
        Label localisationTxt = new Label("prix : "+v.getPrixevent(),"NewsTopLine2");
        Label descriptionTxt = new Label("date : "+v.getDate(),"NewsTopLine2");
     



       
       
        createLineSeparator();
       
   /*     if(rec.getEtat() == 0 ) {
            etatTxt.setText("non Traitée");
        }
        else
            etatTxt.setText("Traitée");
       
       
       */ //supprimer button
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
        supprmierStyle.setFgColor(0xf21f1f);
       
        FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
        lSupprimer.setIcon(suprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
       
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
           
            Dialog dig = new Dialog("Suppression");
           
            if(dig.show("Suppression","Vous voulez supprimer ce voyage ?","Annuler","Oui")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                 }
//                n3ayto l suuprimer men service Reclamation
                if(ServiceEvenement.getInstance().supprimerEvent(v.getIdevent())) {
                    new dispalyEventForm(res).show();
                }
           
        });
       
        //Update icon
       Label lModifier = new Label(" ");
        lModifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);
       
        FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lModifier.setIcon(mFontImage);
        lModifier.setTextPosition(LEFT);
       
       if ((nomTxt.getText().length() == 0) || (localisationTxt.getText().length() == 0) || (descriptionTxt.getText().length() == 0))
                {
                   
                    Dialog.show("Alert", "Please fill all the fields", "OK", "");}
       else {
        lModifier.addPointerPressedListener(l -> {
            //System.out.println("hello update");
            new ModifierEventForm(res,v).show();
        });
       
       
        cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
               
                BoxLayout.encloseX(nomTxt),
                BoxLayout.encloseX(localisationTxt),
                BoxLayout.encloseX(descriptionTxt),
             

               BoxLayout.encloseX(lSupprimer,lModifier)));
       
       
       
        add(cnt);
    }
   
   
    }
    }

   
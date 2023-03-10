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
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServicesReclamation;
import java.util.ArrayList;

/**
 *
 * @author 21695
 */
public class ListeRec  extends BaseForm {
    Form current;
    public ListeRec(Resources res ) {
          super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
       
          Container ct = new Container(BoxLayout.y());
        tb.addSearchCommand(e ->  {
           
        });
       
        Tabs swipe = new Tabs();
       
        Label s1 = new Label();
        Label s2 = new Label();
       
        addTab(swipe,s1, res.getImage("dar-nour-3.jpg"),"","",res);
       
        // Welcome current user
       
      //  System.out.println("user connect?? id ="+ SessionManager.getId());
       
       
       
      //  System.out.println("user connect?? username ="+ SessionManager.getUserName());
       
       // System.out.println("user connect?? password ="+ SessionManager.getPassowrd());
       
      //  System.out.println("user connect?? email ="+ SessionManager.getEmail());
       
       
       
       
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
        RadioButton mesListes = RadioButton.createToggle("les reclamations", barGroup);
        mesListes.setUIID("SelectBar");
     RadioButton liste = RadioButton.createToggle("PDF", barGroup);
       liste.setUIID("SelectBar");
       
        RadioButton stat = RadioButton.createToggle("statistique", barGroup);
        stat.setUIID("SelectBar");
       
       
       
        RadioButton partage = RadioButton.createToggle("Ajouter", barGroup);
        partage.setUIID("SelectBar");
       Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
          ListeRec a = new ListeRec(res);
           a.show();
            refreshTheme();
        });
       
       
//         liste.addActionListener((e) -> {
//               InfiniteProgress ip = new InfiniteProgress();
//        final Dialog ipDlg = ip.showInifiniteBlocking();
//        
//            if (Dialog.show("Confirmation", "Voulez vous imprimer ces reunions en pdf ?", "Oui", "Annuler")) {
//                                                
//                                                              
//                                                                      
//                                                                      
//                                                                        Dialog.show("Success","imprimer",new Command("OK"));
//                                                                        new Pdf(res).show();
//                                                                      
//                                                                  
//
//                                            }
//                                
//        });
//         ct.add(liste);
//        
          liste.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
     //     Pdf a2 = new Pdf(res);
      //     a2.show();
         
            refreshTheme();
        });
             
         stat.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
          StatistiquePieForme a2 = new StatistiquePieForme(res);
           a2.show();
         
            refreshTheme();
        });
       
       
         
         
       
         partage.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
        AjouteReclamationForm a1 = new AjouteReclamationForm(res);
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
        ArrayList<Reclamation>list = ServicesReclamation.getInstance().affichageReclamations();
       
       
        for(Reclamation v : list ) {
           
             String urlImage ="Logo.png";//image statique pour le moment ba3d taw fi  videos jayin nwarikom image
           System.out.println(v);
             Image placeHolder = Image.createImage(120, 90);
             EncodedImage enc =  EncodedImage.createFromImage(placeHolder,false);
             URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
             
                addButton(urlim,v,res);
       
                ScaleImageLabel image = new ScaleImageLabel(urlim);
               
                Container containerImg = new Container();
               
                image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
   
//             String urlImage ="dog.jpg";//image statique pour le moment ba3d taw fi  videos jayin nwarikom image
//             Image placeHolder = Image.createImage(120, 90);
//             EncodedImage enc =  EncodedImage.createFromImage(placeHolder,false);
//             URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
//            
//              //  addButton(urlim,m,res);
//                   addButton(urlim,m,res);
//
//        
//                ScaleImageLabel image = new ScaleImageLabel(urlim);
//                
//                Container containerImg = new Container();
//                
//                image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
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
       
        swipe.addTab("",res.getImage("dog.jpg"), page1);
       
       
       
       
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

    private void addButton(Image img, Reclamation m, Resources res) {
       
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
       
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
       
       
        //kif nzidouh  ly3endo date mathbih fi codenamone y3adih string w y5alih f symfony dateTime w ytab3ni cha3mlt taw yjih
        Label nomTxt = new Label("nom : "+m.getNom(),"NewsTopLine2");
        Label localisationTxt = new Label("prenom : "+m.getPrenom(),"NewsTopLine2");
        Label descriptionTxt = new Label("email : "+m.getEmail(),"NewsTopLine2");
        Label prixTxt = new Label("commentaire : "+m.getCommentaire(),"NewsTopLine2");
         Label prixTxt1 = new Label("datereclamation : "+m.getDatereclamation(),"NewsTopLine2");
        Label imageMaisonTxt = new Label("typereclamation : "+m.getTypereclamation(),"NewsTopLine2");



       
       
     //   createLineSeparator();
       
   /*     if(rec.getEtat() == 0 ) {
            etatTxt.setText("non Trait??e");
        }
        else
            etatTxt.setText("Trait??e");
       */
       
       //supprimer button
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
           
            if(dig.show("Suppression","Vous voulez supprimer cette  Reclamations ?","Annuler","Oui")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                 }
                if(ServicesReclamation.getInstance().supprimerEvent(m.getNumero())) {
                    new ListeRec(res).show();
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
       
       
        lModifier.addPointerPressedListener(l -> {
            System.out.println("hello update");
            new ModifierRecForm(res,m).show();
        });
       
       
        cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
               
                BoxLayout.encloseX(nomTxt),
                BoxLayout.encloseX(localisationTxt),
                BoxLayout.encloseX(descriptionTxt),
                BoxLayout.encloseX(prixTxt),
                BoxLayout.encloseX(prixTxt1),
                BoxLayout.encloseX(imageMaisonTxt),

                           BoxLayout.encloseX(lSupprimer,lModifier)));

       
       
       
        add(cnt);
    }
   
   
}

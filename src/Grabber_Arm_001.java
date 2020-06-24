/*
 * Grabber_Arm_001.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;
import com.google.gson.*;

/** Model exported on Jun 1 2020, 13:12 by COMSOL 5.5.0.292. */
public class Grabber_Arm_001 {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("C:\\Users\\Administrator\\Desktop\\comsolfiles");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("imp1", "Import");
    model.component("comp1").geom("geom1").feature("imp1").set("type", "cad");
    model.component("comp1").geom("geom1").feature("imp1")
         .set("filename", "C:\\Users\\Administrator\\Desktop\\comsolfiles\\Assem1.SLDASM");
    model.component("comp1").geom("geom1").run("");
    model.component("comp1").geom("geom1").feature("imp1")
         .set("filename", "C:\\Users\\Administrator\\Desktop\\comsolfiles\\Gripper v2.SLDASM");

    System.out.println("test1");
    model.component("comp1").geom("geom1").feature("imp1").importData();

    System.out.println("test2");
    model.component("comp1").geom("geom1").feature("fin").set("action", "assembly");
    model.component("comp1").geom("geom1").run("fin");

    System.out.println("test3");
   //serializeModel(model);


    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat1").label("Steel AISI 4340");
    model.component("comp1").material("mat1").set("family", "steel");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("relpermeability_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"4.032e6[S/m]", "0", "0", "0", "4.032e6[S/m]", "0", "0", "0", "4.032e6[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("electricconductivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"12.3e-6[1/K]", "0", "0", "0", "12.3e-6[1/K]", "0", "0", "0", "12.3e-6[1/K]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("thermalexpansioncoefficient_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "475[J/(kg*K)]");
    model.component("comp1").material("mat1").propertyGroup("def").descr("heatcapacity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("relpermittivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "7850[kg/m^3]");
    model.component("comp1").material("mat1").propertyGroup("def").descr("density_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"44.5[W/(m*K)]", "0", "0", "0", "44.5[W/(m*K)]", "0", "0", "0", "44.5[W/(m*K)]"});
    model.component("comp1").material("mat1").propertyGroup("def").descr("thermalconductivity_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("youngsmodulus", "205e9[Pa]");
    model.component("comp1").material("mat1").propertyGroup("Enu").descr("youngsmodulus_symmetry", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("poissonsratio", "0.28");
    model.component("comp1").material("mat1").propertyGroup("Enu").descr("poissonsratio_symmetry", "");
    model.component("comp1").material("mat1").set("groups", new String[][]{});
    model.component("comp1").material("mat1").set("family", "steel");

    System.out.println("test3,5 materials defined");
    //serializeModel(model);

    model.component("comp1").physics().create("mbd", "MultibodyDynamics", "geom1");

    System.out.println("test3,6 physics()");

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(4);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(2);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(1);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(4);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").automatic(false);
    model.component("comp1").mesh("mesh1").feature().duplicate("size1", "size");
    model.component("comp1").mesh("mesh1").feature().duplicate("size2", "size1");
    model.component("comp1").mesh("mesh1").feature().move("ftet1", 3);
    model.component("comp1").mesh("mesh1").feature("size1").selection().geom("geom1", 3);
    model.component("comp1").mesh("mesh1").feature("size1").selection().set(1, 4, 5);
    model.component("comp1").mesh("mesh1").feature("size2").selection().geom("geom1", 3);
    model.component("comp1").mesh("mesh1").feature("size2").selection().all();
    model.component("comp1").mesh("mesh1").feature("size1").selection().all();
    model.component("comp1").mesh("mesh1").feature("size1").selection().set(1, 4, 5);
    model.component("comp1").mesh("mesh1").feature("size2").selection().set(2, 3, 14);
    model.component("comp1").mesh("mesh1").feature().duplicate("size3", "size2");
    model.component("comp1").mesh("mesh1").feature("size3").selection().set(8);
    model.component("comp1").mesh("mesh1").feature("size3").set("hauto", 2);
    model.component("comp1").mesh("mesh1").create("cr1", "CornerRefinement");
    model.component("comp1").mesh("mesh1").feature().move("ftet1", 4);
    model.component("comp1").mesh("mesh1").feature().move("ftet1", 5);

    System.out.println("test3,7");
    //serializeModel(model);

    model.component("comp1").physics("mbd").create("disp1", "Displacement2", 2);
    model.component("comp1").physics("mbd").feature().remove("disp1");

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature().duplicate("size4", "size3");
    model.component("comp1").mesh("mesh1").feature().move("size4", 4);
    model.component("comp1").mesh("mesh1").feature("size4").selection().set(6, 12);
    model.component("comp1").mesh("mesh1").feature("size4").set("custom", false);
    model.component("comp1").mesh("mesh1").feature("size4").set("hauto", 1);
    model.component("comp1").mesh("mesh1").feature("size4").set("custom", true);
    model.component("comp1").mesh("mesh1").feature("size4").set("hcurveactive", true);
    model.component("comp1").mesh("mesh1").feature("size4").set("custom", false);
    model.component("comp1").mesh("mesh1").feature("size4").set("hauto", 1);
    model.component("comp1").mesh("mesh1").feature("size4").set("custom", true);
    model.component("comp1").mesh("mesh1").feature("size4").set("hcurveactive", true);
    model.component("comp1").mesh("mesh1").feature("size4").set("hcurve", 0.1);
    model.component("comp1").mesh("mesh1").feature("size3").set("hauto", 3);
    model.component("comp1").mesh("mesh1").feature("size2").set("hauto", 5);
    model.component("comp1").mesh("mesh1").feature("size1").set("hauto", 5);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").feature("size1").set("hauto", 4);
    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").create("ftet2", "FreeTet");
    model.component("comp1").mesh("mesh1").feature().move("ftet2", 5);
    model.component("comp1").mesh("mesh1").feature("ftet2").selection().geom("geom1", 3);
    model.component("comp1").mesh("mesh1").feature("ftet2").selection().set(4);
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").feature("ftet2").selection().set(1, 4);
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").feature("ftet2").selection().set(1, 4, 5);
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").run("cr1");
    model.component("comp1").mesh("mesh1").feature().duplicate("ftet3", "ftet2");
    model.component("comp1").mesh("mesh1").feature().remove("ftet3");
    model.component("comp1").mesh("mesh1").create("ftri1", "FreeTri");
    model.component("comp1").mesh("mesh1").feature().move("ftri1", 5);
    model.component("comp1").mesh("mesh1").feature().move("ftet2", 8);
    model.component("comp1").mesh("mesh1").feature("ftri1").selection().set(243);
    model.component("comp1").mesh("mesh1").run("ftri1");
    model.component("comp1").mesh("mesh1").feature("ftri1").selection().set(3, 5, 243, 396, 432);
    model.component("comp1").mesh("mesh1").run("ftri1");
    model.component("comp1").mesh("mesh1").feature("ftri1").selection()
         .set(3, 5, 8, 198, 208, 242, 243, 283, 396, 432, 1196);

    System.out.println("test4");
    //serializeModel(model);

    model.component("comp1").view("view1").hideEntities().create("hide1");
    model.component("comp1").view("view1").hideEntities("hide1").geom(2);
    model.component("comp1").view("view1").hideEntities("hide1").add(8);
    model.component("comp1").view("view1").hideObjects().clear();
    model.component("comp1").view("view1").hideEntities().clear();
    model.component("comp1").view("view1").hideMesh().clear();

    model.component("comp1").mesh("mesh1").feature("ftri1").selection()
         .set(3, 5, 8, 184, 201, 208, 242, 243, 283, 395, 396, 432, 622, 640, 641, 643, 646, 701, 832, 1197);
    model.component("comp1").mesh("mesh1").run("ftri1");
    model.component("comp1").mesh("mesh1").feature("ftri1").selection()
         .set(3, 5, 8, 184, 201, 208, 242, 243, 283, 395, 396, 432, 622, 640, 641, 643, 646, 701, 829, 832, 1197);
    model.component("comp1").mesh("mesh1").run("ftri1");
    model.component("comp1").mesh("mesh1").run("cr1");
    model.component("comp1").mesh("mesh1").feature("ftet1").selection().geom("geom1", 3);
    model.component("comp1").mesh("mesh1").feature("ftet1").selection().set(1, 4, 5);
    model.component("comp1").mesh("mesh1").run("ftet1");
    model.component("comp1").mesh("mesh1").feature("ftet2").selection().set(2, 3, 11, 14);
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").feature().duplicate("ftet3", "ftet2");
    model.component("comp1").mesh("mesh1").feature("ftet3").selection().set(8);
    model.component("comp1").mesh("mesh1").feature("size3").set("hauto", 2);
    model.component("comp1").mesh("mesh1").run("ftet3");

    model.component("comp1").view("view1").hideEntities().create("hide1");
    model.component("comp1").view("view1").hideEntities("hide1").geom(2);
    model.component("comp1").view("view1").hideEntities("hide1").add(201);
    model.component("comp1").view("view1").hideEntities().create("hide2");
    model.component("comp1").view("view1").hideEntities("hide2").geom(3);
    model.component("comp1").view("view1").hideEntities("hide2").add(3);
    model.component("comp1").view("view1").hideEntities("hide2").add(1);
    model.component("comp1").view("view1").hideEntities("hide2").add(4);
    model.component("comp1").view("view1").hideEntities("hide2").add(2);
    model.component("comp1").view("view1").hideEntities("hide2").add(5);
    model.component("comp1").view("view1").hideEntities("hide2").add(11);

    model.component("comp1").mesh("mesh1").feature("ftet2").selection().set(2, 3, 9, 11, 14);
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").feature("ftri1").selection()
         .set(3, 5, 8, 184, 201, 208, 242, 243, 283, 395, 396, 432, 622, 640, 641, 643, 646, 648, 650, 656, 657, 687, 689, 701, 703, 725, 730, 732, 743, 745, 748, 750, 754, 829, 832, 1196, 1197);

    model.component("comp1").view("view1").hideObjects().clear();
    model.component("comp1").view("view1").hideEntities().clear();
    model.component("comp1").view("view1").hideMesh().clear();

    model.component("comp1").mesh("mesh1").feature("ftri1").selection()
         .set(3, 5, 8, 184, 198, 201, 208, 242, 243, 283, 395, 396, 432, 622, 640, 641, 643, 646, 648, 650, 656, 657, 687, 689, 701, 703, 725, 730, 732, 743, 745, 748, 750, 754, 829, 832, 1196, 1197);
    model.component("comp1").mesh("mesh1").run("ftri1");
    model.component("comp1").mesh("mesh1").run("cr1");
    model.component("comp1").mesh("mesh1").run("ftet2");
    model.component("comp1").mesh("mesh1").current("ftet3");
    model.component("comp1").mesh().duplicate("mesh2", "mesh1");
    model.component("comp1").mesh("mesh2").automatic(true);
    model.component("comp1").mesh("mesh2").autoMeshSize(3);
    model.component("comp1").mesh("mesh2").run();

    model.label("Grabber-Arm_001.mph");

    System.out.println("test5");
    serializeModel(model);

    return model;
  }
  public static String serializeModel(Model model)
  {
    Gson gson = new Gson();
   // gson.



    JsonObject jsonO = new JsonObject();
    for (ModelNode c: model.component()) {
      System.out.println("# " + c.name());
      for (GeomSequence g: c.geom()) {

        System.out.println("## " + g.name());

        for (GeomFeature f: g.feature()) {
          System.out.println("### " + f.name() + ":" + gson.toJson(f.objectNames()));
        }
      }

      for (MeshSequence ms: c.mesh()) {
        System.out.println("## " + ms.name());
        for (MeshFeature mf: ms.feature()) {
          System.out.println("### " + mf.name());
        //  System.out.println("###-- " + gson.toJson(mf.properties());
        //  System.out.println("###-- " + mf.selection().name());
        // System.out.println("###-- " + mf.outputSelection());
        }
      }

      for (Material m: c.material()) {
        System.out.println("## " + m.name());
        for (Material f: m.feature()) {
          System.out.println("### " + f.name());
        }
      }
    }

  //  String jsonParts = gson.toJson(model.component("comp1").geom("geom1").feature("imp1"));

    jsonO.add("geomfeatures", gson.toJsonTree(model.component("comp1").geom("geom1").feature("imp1").objectNames()));
  //  jsonO.add("materials", gson.toJsonTree(model.component("comp1").material("mat1").propertyGroup("def").info()));



    System.out.println(jsonO);
    return null;
  }
  public static String getM(Model model)
  {

    System.out.println("## model elem");
    for (ModelNode c: model.component()) {
      for (MeshSequence ms: c.mesh()) {

        System.out.println("### " + ms.name());
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println("test0");

    ModelUtil.initStandalone(false);

    run();
  }

}

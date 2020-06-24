/*
 * SolidCube.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/** Model exported on Jun 1 2020, 20:02 by COMSOL 5.5.0.292. */
public class SolidCube {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("C:\\Users\\Administrator\\Desktop\\comsolfiles");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("solid", "SolidMechanics", "geom1");
    model.component("comp1").physics("solid").field("displacement").field("u2");
    model.component("comp1").physics("solid").field("displacement").component(new String[]{"u2", "v2", "w2"});

    model.study().create("std1");
    model.study("std1").create("stat", "Stationary");
    model.study("std1").feature("stat").activate("solid", true);

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics("solid").create("bndl1", "BoundaryLoad", 2);
    model.component("comp1").physics("solid").feature("bndl1").selection().set(1);
    model.component("comp1").physics("solid").feature("bndl1").set("LoadType", "TotalForce");
    model.component("comp1").physics("solid").feature("bndl1").set("Ftot", new int[]{10, 0, 0});

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

    model.component("comp1").physics("solid").create("spf1", "SpringFoundation2", 2);
    model.component("comp1").physics("solid").feature("spf1").selection().set(6);
    model.component("comp1").physics("solid").feature("spf1")
         .set("kPerArea", new String[]{"1e3", "0", "0", "0", "1e3", "0", "0", "0", "1e3"});

    model.component("comp1").mesh("mesh1").run();

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "1");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "1");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature("aDef").set("cachepattern", true);
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("termonres", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("reserrfact", 1000);
    model.sol("sol1").feature("s1").create("d1", "Direct");
    model.sol("sol1").feature("s1").feature("d1").set("linsolver", "mumps");
    model.sol("sol1").feature("s1").feature("d1").label("Suggested Direct Solver (solid)");
    model.sol("sol1").feature("s1").create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("s1").feature("i1").set("rhob", 400);
    model.sol("sol1").feature("s1").feature("i1").set("nlinnormuse", true);
    model.sol("sol1").feature("s1").feature("i1").label("Suggested Iterative Solver (solid)");
    model.sol("sol1").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").set("prefun", "gmg");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").feature("so1").set("relax", 0.8);
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").feature("so1").set("relax", 0.8);
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "d1");
    model.sol("sol1").feature("s1").feature("fc1").set("termonres", "auto");
    model.sol("sol1").feature("s1").feature("fc1").set("reserrfact", 1000);
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").create("surf1", "Surface");
    model.result("pg1").feature("surf1").set("expr", new String[]{"solid.mises"});
    model.result("pg1").label("Stress (solid)");
    model.result("pg1").feature("surf1").set("colortable", "RainbowLight");
    model.result("pg1").feature("surf1").set("resolution", "normal");
    model.result("pg1").feature("surf1").create("def", "Deform");
    model.result("pg1").feature("surf1").feature("def").set("expr", new String[]{"u2", "v2", "w2"});
    model.result("pg1").feature("surf1").feature("def").set("descr", "Displacement field");

    model.nodeGroup().create("dset1solidlgrp", "Results");
    model.nodeGroup("dset1solidlgrp").label("Applied Loads (solid)");
    model.nodeGroup("dset1solidlgrp").set("type", "plotgroup");
    model.nodeGroup("dset1solidlgrp").placeAfter("plotgroup", "pg1");

    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").set("data", "dset1");
    model.result("pg2").label("Boundary Loads (solid)");

    model.nodeGroup("dset1solidlgrp").add("plotgroup", "pg2");

    model.result("pg2").set("showlegends", true);
    model.result("pg2").set("titletype", "custom");
    model.result("pg2").set("typeintitle", false);
    model.result("pg2").set("descriptionintitle", false);
    model.result("pg2").set("unitintitle", false);
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsunit", true);
    model.result("pg2").create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("expr", new String[]{"1"});
    model.result("pg2").feature("surf1").label("Gray Surfaces");
    model.result("pg2").feature("surf1").set("coloring", "uniform");
    model.result("pg2").feature("surf1").set("color", "gray");
    model.result("pg2").feature("surf1").active(false);
    model.result("pg2").feature("surf1").create("def", "Deform");
    model.result("pg2").feature("surf1").feature("def").set("expr", new String[]{"u2", "v2", "w2"});
    model.result("pg2").feature("surf1").feature("def").set("descr", "Displacement field");
    model.result("pg2").feature("surf1").feature("def").set("scaleactive", true);
    model.result("pg2").feature("surf1").feature("def").set("scale", 0);
    model.result("pg2").create("arws1", "ArrowSurface");
    model.result("pg2").feature("arws1")
         .set("expr", new String[]{"solid.bndl1.F_Ax", "solid.bndl1.F_Ay", "solid.bndl1.F_Az"});
    model.result("pg2").feature("arws1").set("placement", "gausspoints");
    model.result("pg2").feature("arws1").set("arrowbase", "tail");
    model.result("pg2").feature("arws1").label("Boundary Load 1");
    model.result("pg2").feature().move("surf1", 1);
    model.result("pg2").feature("arws1").set("inheritplot", "none");
    model.result("pg2").feature("arws1").create("col", "Color");
    model.result("pg2").feature("arws1").feature("col").set("expr", "comp1.solid.bndl1.F_A_Mag");
    model.result("pg2").feature("arws1").feature("col").set("colortable", "Spectrum");
    model.result("pg2").feature("arws1").feature("col").set("coloring", "gradient");
    model.result("pg2").feature("arws1").feature("col").set("topcolor", "red");
    model.result("pg2").feature("arws1").set("color", "red");
    model.result("pg2").feature("arws1").create("def", "Deform");
    model.result("pg2").feature("arws1").feature("def").set("expr", new String[]{"u2", "v2", "w2"});
    model.result("pg2").feature("arws1").feature("def").set("descr", "Displacement field");
    model.result("pg2").feature("arws1").feature("def").set("scaleactive", true);
    model.result("pg2").feature("arws1").feature("def").set("scale", 0);

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().export().create("data1", "Data");
    model.result().export("data1").setIndex("expr", "ht2.rho_eff", 0);
    model.result().export("data1").setIndex("unit", "g/cm^3", 0);
    model.result().export("data1").setIndex("descr", "Effective density", 0);
    model.result().export("data1").setIndex("expr", "solid.mises", 1);
    model.result().export("data1").setIndex("unit", "g/(cm*s^2)", 1);
    model.result().export("data1").setIndex("descr", "von Mises stress", 1);
    model.result().export("data1").setIndex("expr", "dom", 2);
    model.result().export("data1").setIndex("unit", "Entity index", 2);
    model.result().export("data1").setIndex("descr", "", 2);
    model.result().export("data1").setIndex("expr", "material.domain", 3);
    model.result().export("data1").setIndex("unit", "Material settings", 3);
    model.result().export("data1").setIndex("descr", "", 3);
    model.result().export("data1").set("filename", "./SolidCube_data.txt");
    model.result().export("data1").set("recover", "pprint");
    model.result().export("data1").set("smooth", "internal");
    model.result().export("data1").remove("unit", 2);
    model.result().export("data1").remove("descr", 2);
    model.result().export("data1").remove("expr", new int[]{2});
    model.result().export("data1").remove("unit", 0);
    model.result().export("data1").remove("descr", 0);
    model.result().export("data1").remove("expr", new int[]{0});
    model.result().export("data1").remove("unit", 1);
    model.result().export("data1").remove("descr", 1);
    model.result().export("data1").remove("expr", new int[]{1});
    model.result().export("data1").set("expr", new String[]{"solid.mises", "X", "Y", "Z"});
    model.result().export().create("mesh1", "Mesh");
    model.result().export("mesh1").set("filename", "./SolidCube_mesh");
    model.result().export("mesh1").set("type3D", "stlascii");
    model.result().export("data1").remove("unit", new int[]{1, 2, 3});
    model.result().export("data1").remove("descr", new int[]{1, 2, 3});
    model.result().export("data1").remove("expr", new int[]{1, 2, 3});
    model.result().export("data1").set("expr", new String[]{"solid.mises", "solid.mises"});
    model.result().export("data1").set("descr", new String[]{"von Mises stress", "von Mises stress"});
    model.result().export("data1").remove("unit", 0);
    model.result().export("data1").remove("descr", 0);
    model.result().export("data1").remove("expr", new int[]{0});
    model.result().export("data1").set("expr", new String[]{"solid.mises", "dom"});
    model.result().export("data1").set("descr", new String[]{"von Mises stress", "Entity index"});
    model.result().export("data1").set("expr", new String[]{"solid.mises", "dom", "X", "Y", "Z"});
    model.result().export("data1").run();
    model.result().export("data1").set("alwaysask", false);
    model.result().export("data1").run();
    model.result().export("data1").set("alwaysask", false);
    model.result().export("mesh1").set("alwaysask", false);
    model.result().export("mesh1").run();
    model.result().export("mesh1").set("alwaysask", false);
    model.result().export("mesh1").set("filename", "SolidCube_mesh.stl");
    model.result().export("data1").set("filename", "SolidCube_data.txt");

    model.label("SolidCube (1) (1).mph");

    return model;
  }

  public static void main(String[] args) {
    System.out.println("test0");

    ModelUtil.initStandalone(false);
   Model model =  run();

    System.out.println("## model elem");
    for (ModelNode c: model.component()) {
      for (MeshSequence ms: c.mesh()) {


        System.out.println("### " + ms.name());
      }
    }

    System.out.println("testfin");
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

    return null;
  }


}

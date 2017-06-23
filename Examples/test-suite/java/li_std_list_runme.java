import li_std_list.*;

public class li_std_list_runme {

  static {
    try {
        System.loadLibrary("li_std_list");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
      System.exit(1);
    }
  }

  public static void main(String argv[]) throws Throwable
  {
    IntList v1 = new IntList();
    DoubleList v2 = new DoubleList();

    if (!v1.isEmpty()) throw new RuntimeException("v1 test (1) failed");
    if (v1.size() != 0) throw new RuntimeException("v1 test (2) failed");
    if (!v1.add(123)) throw new RuntimeException("v1 test (3) failed");
    if (v1.size() != 1) throw new RuntimeException("v1 test (4) failed");
    if (v1.isEmpty()) throw new RuntimeException("v1 test (5) failed");

    if (v1.get(0) != 123) throw new RuntimeException("v1 test failed");

    StructList v4 = new StructList();
    StructPtrList v5 = new StructPtrList();
    StructConstPtrList v6 = new StructConstPtrList();

    v4.add(new Struct(12));
    v5.add(new Struct(34));
    v6.add(new Struct(56));

    Struct s = null;
    if (v4.get(0).getNum() != 12) throw new RuntimeException("v4 test failed");
    if (v5.get(0).getNum() != 34) throw new RuntimeException("v5 test failed");
    if (v6.get(0).getNum() != 56) throw new RuntimeException("v6 test failed");
  }
}

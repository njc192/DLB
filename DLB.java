

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DLB implements Dict {
	private DLBNode root;

	public DLB() {
		root = null;
	}

	public static void main(String[] args) {
		DLB delabrandais = new DLB();
//		Scanner scanner;
//		try
//		{
//			String fileName = "src/dictionary.txt";
//			scanner = new Scanner(new File(fileName));
//			while(scanner.hasNext())
//			{
//				delabrandais.add(scanner.next());
//			}
//		}
//		catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//
//		System.out.println(delabrandais.contains("zittty"));

		delabrandais.add("beans");
		delabrandais.add("beach");
		delabrandais.add("best");
		delabrandais.traverse(delabrandais.root);
	}

	public boolean contains(String key) {

		return containsHelper(root,key,0);
	}


	public boolean containsHelper(DLBNode t, String key, int index)
	{
		if (t == null)
		{
			return false;
		}
		if(index == key.length())
		{
			if (t.getLet() == '^') // not exactly sure if this should be length or length +1??
			{
				return true;
			}
			return false;
		}

		if (t.getLet() == key.charAt(index))
		{
			return containsHelper(t.getDown(),key,index+1);
		}
		else
		{
			return containsHelper(t.getRight(),key,index);
		}


	}

	public void add(String key) // ****
	{
		if (key == null) {
			System.out.println("ERROR: NULL KEY");
			return;
		}
		if (root == null) {
			root = new DLBNode(key.charAt(0));
			add(root, key, 0);
		} else {
			add(root, key, 0);
		}
	}

	private DLBNode add(DLBNode t, String key, int index) {
		//System.out.println(index);
		if (index == key.length()) {
			t = new DLBNode('^');
			return t;
		}
		if (t == null) {
			t = new DLBNode(key.charAt(index));
		}

		if (t.getLet() == key.charAt(index)) {
			t.setDown(add(t.getDown(), key, index+1)); // this may need to be ++
		} else {
			t.setRight(add(t.getRight(), key, index));
		}
		return t;
	}

	public void traverse(DLBNode test) {
		if (test == null) {
			return;
		} else {
			System.out.println(test.getLet());
		}
		if (test.getDown() != null) {
			traverse(test.getDown());

		}
		if (test.getRight() != null) {
			traverse(test.getRight());
		}
	}

	public boolean containsPrefix(String pre) {
		return false;
	}

	public int searchByChar(char next) {
		return 0;
	}

	public void resetByChar() {

	}

	public ArrayList<String> suggest() {
		return null;
	}

	public ArrayList<String> traverse() {
		return null;
	}

	public int count() {
		return 0;
	}
}

//
// public ArrayList<String> nextChar(char next);
//
// public void finishWord(String cur);
//
// public void saveUserHistory(String fname);
























































































//
//
//import java.util.ArrayList;
//
//public class DLB implements Dict
//{
//	private DLBNode root;
//
//	public static void main(String[] args) {
//		DLB d = new DLB();
//		d.add("beans");
//		d.add("beach");
//		d.add("axe");
//		d.add("ask");
//		d.add("beast");
//		d.add("best");
//		d.add("ache");
//		d.add("ass");
//		d.add("axel");
//		d.traverse(d.root);
//
//	}
//	public boolean contains(String key)
//	{
//		return false;
//	}
//
//	public void add(String key) // ****
//	{
//		if(key == null)
//		{
//			System.out.println("ERROR: NULL KEY");
//		}
//		root = add(root,key,0);
//	}
//
//	private DLBNode add(DLBNode t, String key, int index)
//	{
//		if (index == key.length())
//		{
//			return t;
//		}
//		if (t == null)
//		{
//			t = new DLBNode(key.charAt(index));
//		}
//
//		if (t.getLet() == key.charAt(index))
//		{
//			t.setDown(add(t.getDown(),key,++index));
//		}
//		else
//		{
//			t.setRight(add(t.getRight(),key,index));
//		}
//		return t;
//	}
//
//	public void traverse(DLBNode root)
//	{
//		System.out.println(root.getLet());
//		if (root.getDown() != null)
//		{
//			traverse(root.getDown());
//
//		}
//		if (root.getRight() != null)
//		{
//			traverse(root.getRight());
//		}
//	}
//
//	public boolean containsPrefix(String pre)
//	{
//		return false;
//	}
//
//	public int searchByChar(char next)
//
//	{
//		return 0;
//	}
//
//	public void resetByChar()
//	{
//
//	}
//
//	public ArrayList<String> suggest()
//	{
//		return null;
//	}
//
//	public ArrayList<String> traverse()
//	{
//		return null;
//	}
//
//	public int count()
//	{
//		return 0;
//	}
////
////	public ArrayList<String> nextChar(char next);
////
////	public void finishWord(String cur);
////
////	public void saveUserHistory(String fname);
//}
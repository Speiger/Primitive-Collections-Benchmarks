package speiger.src;

import java.util.Arrays;
import java.util.List;

import speiger.src.collections.objects.lists.ObjectArrayList;

/**
 * 
 * @author Speiger
 * License All rights reserved
 */
public class TableGenerator {
	
	public static void main(String... args) {
		List<List<String>> list = new ObjectArrayList<>();
		list.add(ObjectArrayList.wrap("Test0", "Test1", "Test2"));
		list.add(ObjectArrayList.wrap("Testing", "Test", "15,499"));
		list.add(ObjectArrayList.wrap("Testing2323232", "Test323223", "239,208"));
		list.add(ObjectArrayList.wrap("Testing", "Test", "14.512,36"));
		
		List<ColumnSettings> tests = new ObjectArrayList<>();
		tests.add(new ColumnSettings(2, 2, Alignment.CENTER));
		tests.add(new ColumnSettings(2, 2, Alignment.LEFT));
		tests.add(new ColumnSettings(2, 2, Alignment.CENTER));
		tests.add(new ColumnSettings(2, 2, 3, "[,/]", Alignment.RIGHT));
		
		System.out.println("Tests:\n"+buildTable(list, tests, true));
	}
	
	public static String buildTable(List<List<String>> table, List<ColumnSettings> settings, boolean firstIsHeader) {
		if(table.isEmpty()) return "";
		int size = validateTable(table, settings, firstIsHeader);
		calculateColumnWidth(table, settings, firstIsHeader, size);
		
		StringBuilder builder = new StringBuilder();
		if(firstIsHeader) {
			ColumnSettings mainSetting = settings.get(0);
			List<String> header = table.get(0);
			for(int j = 0,n=header.size();j<n;j++) {
				ColumnSettings setting = settings.get(j+1);
				String element = header.get(j);
				builder.append("|").append(setting.buildEmptyChars());
				int start = builder.length() - setting.getAlignOffset(element.length(), mainSetting.alignment);
				builder.replace(start, start+element.length(), element);
			}
			builder.append("|\n");
			for(int j = 0,n=header.size();j<n;j++) {
				ColumnSettings setting = settings.get(j+1);
				builder.append("|").append(setting.buildSeparatorChars());
			}
			builder.append("|\n");
		}
		
		int firstIndex = firstIsHeader ? 1 : 0;
		for(int i = firstIndex,m=table.size();i<m;i++) {
			List<String> row = table.get(i);
			for(int j = 0,n=row.size();j<n;j++) {
				ColumnSettings setting = settings.get(j+firstIndex);
				String element = row.get(j);
				builder.append("|").append(setting.buildEmptyChars());
				if(setting.minimumRight > 0) {
					String[] split = element.split(setting.minimumIndicator, 2);
					if(split.length != 2) throw new IllegalStateException("Element ["+element+"] is missing a Spliting Indicator");
					int length = split[0].length()+1+Math.max(split[1].length(), setting.minimumRight);
					int start = builder.length() - setting.getAlignOffset(length);
					builder.replace(start, start+element.length(), element);
				}
				else {
					int start = builder.length() - setting.getAlignOffset(element.length());
					builder.replace(start, start+element.length(), element);
				}
			}
			builder.append("|\n");
		}
		
		return builder.toString();
	}
	
	private static int validateTable(List<List<String>> table, List<ColumnSettings> settings, boolean firstIsHeader) {
		int size = table.get(0).size();
		for(int i = 0,m=table.size();i<m;i++) {
			if(table.get(i).size() != size) throw new IllegalStateException("Table Index ["+i+"] Index isn't the same Column size as the rest!");
		}
		if(size != settings.size() - (firstIsHeader ? 1 : 0)) throw new IllegalStateException("Settings size isn't the same size as Table Column Size");
		return size;
	}
	
	private static void calculateColumnWidth(List<List<String>> list, List<ColumnSettings> settings, boolean firstIsHeader, int size) {
		int startIndex = firstIsHeader ? 1 : 0;
		if(firstIsHeader) {
			ColumnSettings padding = settings.get(0);
			for(int i = 0,m=list.get(0).size();i<m;i++) {
				ColumnSettings setting = settings.get(i+startIndex);
				setting.width = Math.max(setting.width, padding.leftPadding+padding.rightPadding+list.get(0).get(i).length());
			}
		}
		for(int i = startIndex,m=list.size();i<m;i++) {
			List<String> column = list.get(i);
			for(int j = 0;j<column.size();j++) {
				ColumnSettings setting = settings.get(startIndex+j);
				String s = list.get(i).get(j);
				int length = s.length();
				if(setting.minimumRight > 0) {
					String[] split = s.split(setting.minimumIndicator, 2);
					if(split.length != 2) throw new IllegalStateException("Element ["+s+"] is missing a Spliting Indicator");
					length = split[0].length()+1+Math.max(split[1].length(), setting.minimumRight);
				}
				setting.width = Math.max(setting.width, setting.leftPadding+setting.rightPadding+Math.max(list.get(i).get(j).length(), length));
			}
		}
	}
	
	public static class ColumnSettings {
		int leftPadding;
		int rightPadding;
		int minimumRight;
		String minimumIndicator;
		Alignment alignment;
		int width;
		char[] cache = null;
		
		
		public ColumnSettings(int leftPadding, int rightPadding, Alignment alignment) {
			this(leftPadding, rightPadding, 0, "", alignment);
		}
		
		public ColumnSettings(int leftPadding, int rightPadding, int minimumRight, String minimumIndicator, Alignment alignment) {
			this.leftPadding = leftPadding;
			this.rightPadding = rightPadding;
			this.minimumRight = minimumRight;
			this.minimumIndicator = minimumIndicator;
			this.alignment = alignment;
		}
		
		public char[] buildEmptyChars() {
			if(cache == null) {
				cache = new char[width];
				Arrays.fill(cache, ' ');
			}
			return cache;
		}
		
		public char[] buildSeparatorChars() {
			char[] separators = new char[width];
			Arrays.fill(separators, '-');
			return separators;
		}
		
		public int getAlignOffset(int length) {
			return getAlignOffset(length, alignment);
		}
		
		public int getAlignOffset(int length, Alignment align) {
			switch(align) {
				case LEFT: return width - leftPadding;
				case CENTER: return (int)Math.round((width / 2F) + (length / 2F) + rightPadding - leftPadding);
				case RIGHT: return length + rightPadding;
				default: return leftPadding;
			}
		}
	}
	
	public static enum Alignment {
		LEFT,
		CENTER,
		RIGHT;
	}
}

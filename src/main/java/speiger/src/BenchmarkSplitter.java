package speiger.src;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

import speiger.src.collections.objects.lists.ObjectArrayList;
import speiger.src.collections.objects.maps.interfaces.Object2ObjectMap;
import speiger.src.collections.objects.utils.maps.Object2ObjectMaps;

public class BenchmarkSplitter
{
	
	public static void main(String[] args)
	{
		try
		{
			Object2ObjectMap<String, Object2ObjectMap<String, List<JsonObject>>> unMappedObjects = Object2ObjectMap.builder().linkedMap();
			for(JsonElement el : JsonParser.parseReader(Files.newBufferedReader(Paths.get(args[0]))).getAsJsonArray())
			{
				JsonObject obj = el.getAsJsonObject();
				String[] s = obj.get("benchmark").getAsString().split("\\.");
				unMappedObjects.supplyIfAbsent(s[s.length-3], Object2ObjectMap.builder()::linkedMap).supplyIfAbsent(s[s.length-1], ObjectArrayList::new).add(obj);
			}
			Path folder = Paths.get(args[1]);
			if(Files.notExists(folder)) Files.createDirectories(folder);
			for(Object2ObjectMap.Entry<String, Object2ObjectMap<String, List<JsonObject>>> entry : Object2ObjectMaps.fastIterable(unMappedObjects))
			{
				JsonArray array = new JsonArray();
				entry.getValue().values().flatMap(T -> T).forEach(array::add);
				try(JsonWriter writer = new JsonWriter(Files.newBufferedWriter(folder.resolve(entry.getKey()+".json"))))
				{
					writer.setIndent("\t");
					Streams.write(array, writer);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

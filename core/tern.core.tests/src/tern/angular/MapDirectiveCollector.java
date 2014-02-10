package tern.angular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tern.angular.modules.Directive;
import tern.angular.modules.DirectiveParameter;
import tern.angular.modules.IDirectiveCollector;

public class MapDirectiveCollector implements IDirectiveCollector {

	private final List<String> names;
	private final Map<String, Directive> directives;
	private final Map<String, DirectiveParameter> parameters;

	public MapDirectiveCollector() {
		names = new ArrayList<String>();
		directives = new HashMap<String, Directive>();
		parameters = new HashMap<String, DirectiveParameter>();
	}

	@Override
	public void add(Directive directive, String nameWhichMatch) {
		directives.put(directive.getName(), directive);
		names.add(nameWhichMatch);
		System.err.println(directive.getName() + ", " + nameWhichMatch);
	}

	@Override
	public void add(DirectiveParameter parameter) {
		parameters.put(parameter.getName(), parameter);
	}

	public List<String> getNames() {
		return names;
	}

	public Map<String, Directive> getDirectives() {
		return directives;
	}

	public Map<String, DirectiveParameter> getParameters() {
		return parameters;
	}

}

OrderedIdentityDictionary {
	var keys, dict;

	*new {
		^super.new.init;
	}

	init {
		keys = OrderedIdentitySet.new;
		dict = IdentityDictionary.new;
	}

	put {
		arg key, value;
		keys.add(key);
		dict[key] = value;
	}

	do {
		arg func;
		keys.do{
			arg key;
			func.(dict[key]);
		}
	}

	keysValuesDo {
		arg func;
		keys.do{
			arg key;
			func.(key,dict[key]);
		}
	}

	remove {
		arg key;
		keys.remove(key);
		dict[key] = nil;
	}

	at {
		arg key;
		^this.atKey(key);
	}

	atKey {
		arg key;
		^dict[key];
	}

	valueAtIndex {
		arg index;
		^dict[this.keyAtIndex(index)];
	}

	keyAtIndex {
		arg index;
		^keys.asArray[index];
	}

	keyValueAtIndex {
		arg index;
		var key = this.keyAtIndex(index);
		^[key,dict[key]];
	}

	size {
		^keys.size;
	}

}
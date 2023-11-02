OrderedIdentityDictionary {
	var <keys, dict;

	*new {
		^super.new.init;
	}

	init {
		keys = OrderedIdentitySet.new;
		dict = IdentityDictionary.new;
	}

	includesKey {
		arg k;
		^dict.includesKey(k);
	}

	put {
		arg key, value;
		keys.add(key);
		dict[key] = value;
	}

	do {
		arg func;
		keys.do{
			arg key,i;
			func.(dict[key],i);
		}
	}

	collect {
		arg func;
		^keys.collect{
			arg key,i;
			func.(dict[key],i);
		}
	}

	keysValuesDo {
		arg func;
		keys.do{
			arg key,i;
			func.(key,dict[key],i);
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

	atIndex {
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

	postln {
		var longest = this.keys.collect{arg k; k.asString.size}.maxItem;
		this.keysValuesDo{
			arg k, v;
			"%\t%".format("%:".format(k).padRight(longest),v).postln;
		};
	}
}
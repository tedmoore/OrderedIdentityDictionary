(
o = OrderedIdentityDictionary.new;
d = IdentityDictionary.new;

[\zero,\one,\two,\three,\four,\five,\six,\seven,\eight,\nine,\ten,\eleven,\twelve].do{
	arg k,i;
	o[k] = i;
	d[k] = i;
};

d.do{
	arg n;
	n.postln;
};

"".postln;

d.size.postln;
"".postln;

o.do{
	arg n;
	n.postln;
};

"".postln;

o.size.postln;
"".postln;

o.keysValuesDo{
	arg k, v;
	"%\t\t%".format(k,v).postln;
};

"\nremove\n".postln;

o.remove(\seven);

"\nremoved".postln;

o.keysValuesDo{
	arg k, v;
	"%\t\t%".format(k,v).postln;
};

"".postln;

o.size.postln;
"".postln;

o[\six].postln;
o.size.do{
	arg i;
	i.post;
	"\t".post;
	o.keyValueAtIndex(i).postln;
}
)
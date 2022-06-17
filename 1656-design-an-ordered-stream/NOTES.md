[3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]
index = idKey-1;
[null,null,null,null,null]
[null,null,ccccc,null,null] return []
[aaaaa,null,ccccc,null,null] return [aaaaa]
[aaaaa,bbbbb,ccccc,null,null] return [bbbbb,ccccc]
[aaaaa,bbbbb,ccccc,null,eeeee] return []
[aaaaa,bbbbb,ccccc,ddddd,eeeee] return [ddddd,eeeee]
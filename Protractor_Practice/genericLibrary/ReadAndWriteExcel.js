describe("Fist Protractor Program",function readExcel()
{
	it("Open AngularJS page and enter values into edit boxes and perform addition",function()
		{
		var node_xj = require("xls-to-json"); //node-excel-to-json xls-to-json
		  node_xj({
		    input: "./TestData/TestData.xls",  // input xls
		    output: "./TestData/TestData.json", // output json
		    sheet: "Sheet1"  // specific sheetname
		  }, function(err, result) {
		    if(err) {
		      console.error(err);
		    } else {
		      console.log(result);
		    }
		  });
		
		
		});
	
	it("welcome",function()
	{
		console.log("Welcome");
	})
	
})
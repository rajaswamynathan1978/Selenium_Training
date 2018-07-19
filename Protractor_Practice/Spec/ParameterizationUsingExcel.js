
describe('Fist Protractor Program',function()
		{
			var using=require('jasmine-data-provider');
	
	
			it('Open AngularJS page and enter values into edit boxes and perform addition',function()
					{
				        browser.get("http://juliemr.github.io/protractor-demo/");
				        var testData=require('../TestData/TestData.json');
				        
				 using(testData,function (params_,description)
				 {
					 	element(by.model("first")).sendKeys(params_.FirstInput);
				        element(by.model("second")).sendKeys(params_.SecondInput);
				        element(by.css("option[value='MULTIPLICATION")).click();
				        element(by.css("button[id='gobutton']")).click().then(function()
				        {
				        	browser.sleep(12000);
				        	element(by.css("h2[class='ng-binding']")).getText().then (function(myVal)
				        	{
				        		console.log("The Result is "+ myVal);
				        	});
				        	element(by.css("td[class='ng-binding']")).getText().then (function(myVal1)
				        	{
				        		console.log("The Time is "+ myVal1);
				        	});
				        	});	 
					 
					 
				 })})})
			  
		/*	  it('Open AngularJS page and enter values into edit boxes and perform addition',function()
					{
				  var testData=require('../TestData/TestData.json').getText().then (function(myData)
				  {
					  console.log("OutPut is " + myData);
				  })					  
				  })
		*/		  

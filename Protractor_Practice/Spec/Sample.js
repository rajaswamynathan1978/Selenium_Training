
describe('Fist Protractor Program',function()
		{
			it('Open AngularJS page and enter values into edit boxes and perform addition',function()
					{
				        browser.get("http://juliemr.github.io/protractor-demo/");
				        element(by.model("first")).sendKeys("17");
				        element(by.model("second")).sendKeys("25");
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
				        	}
				        	);
					}
			  )
			  
		/*	  it('Open AngularJS page and enter values into edit boxes and perform addition',function()
					{
				  var testData=require('../TestData/TestData.json').getText().then (function(myData)
				  {
					  console.log("OutPut is " + myData);
				  })					  
				  })
		*/		  
		})
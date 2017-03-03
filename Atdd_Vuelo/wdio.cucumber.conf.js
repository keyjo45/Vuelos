exports.config = {
    specs: [
		'./features/*.feature'
    ],
    capabilities: [{
        browserName: 'chrome'
    }],
    sync: true,
    logLevel: 'silent',
    coloredLogs: true,
	waitforTimeout: 10000,
    framework: 'cucumber',
    services: ['selenium-standalone'],
	cucumberOpts: {
        require: ['./tests/IngresoTest.js']
    },
    reporters: ['spec','junit'],
    reporterOptions: {
        junit: {
            outputDir: './reports/'
        }
    }
}

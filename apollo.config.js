module.exports = {
  service: {
    name:'jeongjiyoun-9176',
    localSchemaFile: './src/main/graphql/schema.graphql',
    ENGINE_API_KEY: 'yzZU7AGP0fRGXWabbFG13A',
    endpoint:"https://api.github.com/graphql",
    service: {
            url: "https://api.github.com/graphql",
        },
        includes: [
            "src/main/graphql/.{ts,tsx,js,jsx,graphql}"
        ]

  }
};
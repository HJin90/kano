module.exports = {
  service: {
    name:'jeongjiyoun-9176',
    localSchemaFile: './src/main/graphql/schema.json',
    endpoint:"https://api.github.com/graphql",
    service: {
            url: "https://api.github.com/graphql",
        },
        includes: [
            "src/main/graphql/.{ts,tsx,js,jsx,graphql}"
        ]

  },
    engine: {
      apiKey: apollo.env.ENGINE_API_KEY
    },
};
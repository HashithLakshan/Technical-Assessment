# Stage 1: Build the Angular application
FROM node:18-alpine as build

WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy the rest of the frontend code
COPY . .

# Build the Angular application
# --output-path specifies where the build artifacts go
# --configuration production for optimized build
RUN npm run build -- FrontEnd --configuration=production

# Stage 2: Serve the Angular application with Nginx
FROM nginx:alpine

# Copy custom Nginx configuration (optional but recommended)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy the built Angular app from the build stage to Nginx's web root
COPY --from=build /app/dist/front-end/browser /usr/share/nginx/html

# Expose port 80 for the web server
EXPOSE 80

# Command to start Nginx
CMD ["nginx", "-g", "daemon off;"]
FROM python:3.6

WORKDIR /usr/src/app
COPY requirements.txt ./
RUN pip install -r requirements.txt
COPY . .

EXPOSE 80
CMD ["python", "javamator/manage.py", "runserver", "0.0.0.0:80"]
variable "access_key" {}
variable "secret_key" {}

variable "region" {
    type = string
    description = "aws region where the VM will be provisioned"
    default = "eu-west-3"
}

variable "ami" {
    type = string
    description = "aws ami used to provision the VM"
    default = "ami-0c6ebbd55ab05f070"
}

variable "instance_ssh_public_key" {
    type = string
    description = "your ssh public key"
}

data "http" "my_public_ip" {
    url = "https://ifconfig.co/json"
    request_headers = {
        Accept = "application/json"
    }
}

locals {
    my_ip = jsondecode(data.http.my_public_ip.body)
}

data "aws_ami" "ubuntu_bionic_ami" {
  most_recent = true
  owners      = ["${var.id_compte_ubuntu}"]

  filter {
    name   = "name"
    values = ["${var.nom_ubuntu_ami}"]
  }
}

resource "aws_instance" "shop-ec2" {
  ami               = data.aws_ami.ubuntu_bionic_ami.id
  instance_type     = var.type_instance
  key_name          = var.cle_ssh
  availability_zone = var.zone_dispo
  security_groups   = ["${var.securite_groupe}"]
  tags = {
    Name = "${var.ec2_name}-ec2"
  }

  provisioner "local-exec" {
    command = "echo GestionGlasses est disponible sur cette url : http://${var.ip_public}:8080/ >> ip_connection.txt"
  }

  provisioner "remote-exec" {
    inline = [
      "sudo apt update -y",
      "sudo apt install software-properties-common",
      "sudo add-apt-repository --yes --update ppa:ansible/ansible",
      "sudo apt install --yes ansible",
      "git clone https://github.com/YounessT28/LoginSpring.git",
      "cd LoginSpring/devOps/ansible",
      "ansible-galaxy install -r requirements.yml --force",
      "ansible-playbook -i playbook.yml inventory.yml"
    ]
    connection {
      type        = "ssh"
      user        = "ubuntu"
      private_key = file("../.aws/${var.cle_ssh}.pem")
      host        = "${self.public_ip}"
    }
  }


}
